package com.cinema.web;

import com.cinema.entity.*;
import com.cinema.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class WebController {

    @Autowired
    private FilmInfoService filmInfoService;

    @Autowired
    private BannerInfoService bannerInfoService;

    @Autowired
    private FilmClassificationService filmClassificationService;

    @Autowired
    private FavoriteInfoService favoriteInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private CommentInfoService commentInfoService;

    @Autowired
    private FilmListService filmListService;

    @Autowired
    private PlayScheduleInfoService playScheduleInfoService;

    @Autowired
    private JournalismInfoService journalismInfoService;

    @Autowired
    private FilmEncyclopediaService filmEncyclopediaService;
    /**
     * 首页跳转
     *      1、查询推荐电影
     *      2、查询广告轮播图
     */
    @GetMapping({"/toIndex","/"})
    public String toIndex(Model model, HttpSession session){

        // 协同过滤算法电影推荐
        List<FilmInfo> filmInfos = filmInfoService.getListFilmArithmetic((UserInfo) session.getAttribute("user"));

        // 查询未下架广告轮播图
        List<BannerInfo> bannerInfos = bannerInfoService.getAll();

        model.addAttribute("filmList",filmInfos);
        model.addAttribute("bannerList",bannerInfos);

        getUserById(model, session);
        return "system/index";
    }

    /**
     * 电影页面跳转
     */
    @GetMapping("toFilmList")
    public String toFilmList(@RequestParam(value = "id", required = false) Integer id,
                             @RequestParam(value = "title", required = false) String title,
                             Model model, HttpSession session){
        List<FilmInfo> all = filmInfoService.getListByClassificationIdAndTitle(id, title);
        model.addAttribute("filmList",all);
        List<FilmClassification> classificationList = filmClassificationService.getAll();
        model.addAttribute("classificationList",classificationList);

        if (!getUserByIdIf(model, session)) {
            return "system/login";
        }

        return "system/film-list";
    }

    /**
     * 跳转电影排行榜
     */
    @GetMapping("toRankingList")
    public String toRankingList(Model model, HttpSession session){
        // 查询总榜数据
        List<FilmList> type1 = filmListService.getByType("1");
        // 查询亲情榜数据
        List<FilmList> type2 = filmListService.getByType("2");
        List<FilmList> type3 = filmListService.getByType("3");
        List<FilmList> type4 = filmListService.getByType("4");
        Map<String, List<FilmList>> map = new HashMap<>();
        map.put("type1", type1);
        map.put("type2", type2);
        map.put("type3", type3);
        map.put("type4", type4);
        model.addAttribute("list",map);

        if (!getUserByIdIf(model, session)) {
            return "system/login";
        }

        return "system/ranking-list";
    }

    /**
     * 用户观影系统统计
     */
    @GetMapping("toHabitList")
    public String toHabitList(Model model, HttpSession session){
        List<FilmClassification> filmClassifications = filmClassificationService.getHabitList();
        model.addAttribute("filmClassifications",filmClassifications);
        if (!getUserByIdIf(model, session)) {
            return "system/login";
        }
        return "system/habit-list";
    }


    /**
     * 跳转电影新闻资讯列表
     */
    @GetMapping("toJournalismList")
    public String toJournalismInfo(Model model, HttpSession session){
        List<JournalismInfo> journalismInfos = journalismInfoService.getAll();
        model.addAttribute("list",journalismInfos);
        if (!getUserByIdIf(model, session)) {
            return "system/login";
        }
        return "system/journalism-list";
    }


    /**
     * 跳转电影新闻资讯详情
     */
    @GetMapping("toJournalismDetail")
    public String toJournalismDetail(@RequestParam("id")int id, Model model, HttpSession session){
        JournalismInfo journalismInfo = journalismInfoService.getById(id);

        model.addAttribute("journalismInfo",journalismInfo);
        if (!getUserByIdIf(model, session)) {
            return "system/login";
        }
        return "system/journalism-detail";
    }


    /**
     * 跳转电影百科
     */
    @GetMapping("toFilmEncyclopediaList")
    public String toFilmEncyclopediaList(Model model, HttpSession session){
        List<FilmEncyclopedia> filmEncyclopedias = filmEncyclopediaService.getAll();

        model.addAttribute("list",filmEncyclopedias);
        if (!getUserByIdIf(model, session)) {
            return "system/login";
        }
        return "system/encyclopedia-list";
    }

    /**
     * 跳转电影百科详情
     */
    @GetMapping("toFilmEncyclopediaDetail")
    public String toFilmEncyclopediaDetail(@RequestParam("id")int id, Model model, HttpSession session){
        FilmEncyclopedia filmEncyclopedia = filmEncyclopediaService.getById(id);

        model.addAttribute("filmEncyclopedia",filmEncyclopedia);
        if (!getUserByIdIf(model, session)) {
            return "system/login";
        }
        return "system/encyclopedia-detail";
    }


    /**
     * 电影详情页面跳转
     *      1、查询详情信息
     *      2、通过当前电影类型查询类似电影
     * @param id
     * @param model
     * @return
     */
    @GetMapping({"/toFilmDetail"})
    public String toFilmDetail(@RequestParam("id")int id,
                               Model model, HttpSession session){
        // 查询详情信息
        FilmInfo filmInfo = filmInfoService.getById(id);
        model.addAttribute("filmInfo",filmInfo);

        // 通过当前电影类型查询类似电影
        List<FilmInfo> similarList = filmInfoService.getListByClassificationIdIsNotFilmInfoId(filmInfo.getClassificationId(), filmInfo.getId());
        model.addAttribute("similarList", similarList);
        if (!getUserByIdIf(model, session)) {
            return "system/login";
        }
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        // 查询是否收藏
        boolean favorite = favoriteInfoService.getByUidAndFid(userInfo.getId(), id);
        model.addAttribute("favorite", favorite);

        // 查询评论
        List<CommentInfo> commentList = commentInfoService.getAll();
        model.addAttribute("commentList", commentList);
        return "system/film-detail";
    }

    /**
     * 电影播放页面跳转
     *      1、查询详情信息
     *      2、通过当前电影类型查询类似电影
     * @param id
     * @param model
     * @return
     */
    @GetMapping({"/toFilmPlay"})
    public String toFilmPlay(@RequestParam("id")int id, Model model, HttpSession session){
        FilmInfo filmInfo = filmInfoService.getById(id);
        model.addAttribute("filmInfo",filmInfo);
        if (!getUserByIdIf(model, session)) {
            return "system/login";
        }
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        PlayScheduleInfo playScheduleInfo = playScheduleInfoService.getPlayScheduleByUidAndFId(userInfo.getId(), id);
        if(playScheduleInfo == null){
            playScheduleInfo = new PlayScheduleInfo();
            playScheduleInfo.setFid(id);
            playScheduleInfo.setUid(userInfo.getId());
            playScheduleInfo.setSchedule(0);
            playScheduleInfoService.save(playScheduleInfo);
            playScheduleInfo = playScheduleInfoService.getPlayScheduleByUidAndFId(userInfo.getId(), id);
        }
        filmInfo.setPlayScheduleInfo(playScheduleInfo);
        return "system/film-play";
    }

    /**
     * 意见反馈页面跳转
     */
    @GetMapping({"/toFeedback"})
    public String toFeedback(Model model, HttpSession session){
        if (!getUserByIdIf(model, session)) {
            return "system/login";
        }
        return "system/feedback";
    }

    /**
     * 个人中心页面跳转
     */
    @GetMapping({"/toMyAccount"})
    public String toMyAccount(Model model, HttpSession session){
        if (!getUserByIdIf(model, session)) {
            return "system/login";
        }
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        List<PlayScheduleInfo> playScheduleInfos = playScheduleInfoService.getPlayScheduleListByUid(userInfo.getId());
        System.out.println(playScheduleInfos);
        model.addAttribute("filmList",playScheduleInfos);
        List<FavoriteInfo> favoriteInfos = favoriteInfoService.getFavoriteInfoListByUid(userInfo.getId());
        model.addAttribute("favoriteList",favoriteInfos);
        return "system/myAccount";
    }


    /**
     * 登录页面跳转
     * @return
     */
    @GetMapping({"/toLogin"})
    public String login(){
        return "system/login";
    }

    /**
     * 跳转注册页面
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "system/register";
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/LoginOut")
    public String LoginOut(HttpSession session){
        // 注销登录状态
        session.invalidate();

        return "system/login";
    }


    /**
     * 获取登录用户信息
     * @param session
     */
    public void getUserById(Model model, HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        if(userInfo != null){
            UserInfo userInfos = userInfoService.getUserInfoByUsername(userInfo.getUsername());
            // 存储登录信息
            session.setAttribute("user",userInfos);
            model.addAttribute("userInfo",userInfos);
        }
    }

    /**
     * 获取登录用户信息
     * @param session
     */
    public boolean getUserByIdIf(Model model, HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        if(userInfo == null){
            return false;
        }

        model.addAttribute("userInfo",userInfoService.getById(userInfo.getId()));
        return true;
    }


}
