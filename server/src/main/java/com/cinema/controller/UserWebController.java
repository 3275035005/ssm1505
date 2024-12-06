package com.cinema.controller;

import com.cinema.entity.*;
import com.cinema.service.*;
import com.cinema.utils.R;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 对前台提供接口
 */
@RequestMapping("userWeb")
@RestController
public class UserWebController {


    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private FilmInfoService filmInfoService;

    @Autowired
    private FeedbackInfoService feedbackInfoService;

    @Autowired
    private FavoriteInfoService favoriteInfoService;

    @Autowired
    private CommentInfoService commentInfoService;

    @Autowired
    private PlayScheduleInfoService playScheduleInfoService;

    /**
     * 用户平台登录接口
     */
    @PostMapping("login")
    public R login(HttpSession session, @RequestBody UserInfo userInfo){
        UserInfo userInfos = userInfoService.getUserInfoByUsername(userInfo.getUsername());
        if(userInfos == null){
            return R.error("请输入正确的账号");
        }
        if(!userInfo.getPassword().equals(userInfos.getPassword())){
            return R.error("请输入正确的密码");
        }
        String status = userInfos.getStatus();
        if("0".equals(status)){
            return R.error("账号已被禁用");
        }

        // 存储登录信息
        session.setAttribute("user",userInfos);

        return R.ok("登录成功").put("row", userInfos);
    }



    /**
     * 用户平台注册接口
     */
    @PostMapping("register")
    public R register(@RequestBody UserInfo userInfo){
        String username = userInfo.getUsername();
        UserInfo userInfoByUsername = userInfoService.getUserInfoByUsername(username);
        if(userInfoByUsername != null){
            return R.error("账号已被注册");
        }

        userInfo.setRole("1");
        userInfo.setStatus("1");
        userInfoService.save(userInfo);
        return R.ok("注册成功");
    }


    /**
     * 反馈与意见
     */
    @PostMapping("sendFeedback")
    public R register(HttpSession session, @RequestBody FeedbackInfo feedbackInfo){
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        feedbackInfo.setUid(userInfo.getId());
        feedbackInfoService.save(feedbackInfo);
        return R.ok("反馈意见成功！");
    }

    /**
     * 修改个人信息
     */
    @PostMapping("updateUserInfo")
    public R updateUserInfo(HttpSession session, @RequestBody UserInfo userInfo){
        userInfoService.update(userInfo);
        UserInfo userInfo1 = userInfoService.getById(userInfo.getId());

        // 存储登录信息
        session.setAttribute("user",userInfo1);

        return R.ok();
    }

    /**
     * 修改密码
     * @param userInfo
     * @return
     */
    @PostMapping("updatePassword")
    public R updatePassword(HttpSession session, @RequestBody UserInfo userInfo){
        userInfoService.update(userInfo);
        // 注销登录状态
        session.invalidate();
        return R.ok();
    }

    /**
     * 收藏和取消收藏功能
     * @param favoriteInfo
     * @return
     */
    @PostMapping("favorite")
    public R favorite(HttpSession session, @RequestBody FavoriteInfo favoriteInfo){
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        if("1".equals(favoriteInfo.getType())){ // 取消收藏

            favoriteInfoService.deleteByUidAndFid(userInfo.getId(), favoriteInfo.getFid());

            return R.ok("取消收藏成功");
        }else{ // 收藏
            favoriteInfo.setUid(userInfo.getId());
            favoriteInfoService.save(favoriteInfo);
            return R.ok("收藏成功");
        }
    }

    /**
     * 发布评论
     * @param commentInfo
     * @return
     */
    @PostMapping("sendComment")
    public R favorite(HttpSession session, @RequestBody CommentInfo commentInfo){
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        commentInfo.setUid(userInfo.getId());
        commentInfoService.save(commentInfo);

        return R.ok("发布评论成功");
    }

    /**
     * 更新播放进度
     */
    @PostMapping("updatePlay")
    public R updatePlay(HttpSession session, @RequestBody PlayScheduleInfo playScheduleInfo){
        playScheduleInfo.setSchedule(playScheduleInfo.getSchedule());
        playScheduleInfoService.update(playScheduleInfo);
        return R.ok();
    }

    /**
     * 判断是否当前用户是否是会员观看电影
     */
    @PostMapping("getFilmInfoByMember/{id}")
    public R getFilmInfoByMember(@PathVariable Integer id, HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        FilmInfo filmInfo = filmInfoService.getById(id);
        if("1".equals(filmInfo.getMember())){
            UserInfo userInfo1 = userInfoService.getById(userInfo.getId());
            if(!"1".equals(userInfo1.getMember())){
                return R.error();
            }
        }
        return R.ok();
    }

    /**
     * 充值成功
     * @param id
     * @return
     */
    @PostMapping("recharge/{id}")
    public R recharge(@PathVariable Integer id) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        UserInfo userInfo = userInfoService.getById(id);
        userInfo.setStatus("1");
        String memberTime = userInfo.getMemberTime();
        if(StringUtil.isEmpty(memberTime)){
            userInfo.setMemberTime(f.format(new Date()));
        }else{
            Date parse = f.parse(memberTime);
            parse.setTime(parse.getTime()+ 31L* 24L * 60L * 60L * 1000L);
            userInfo.setMemberTime(f.format(parse));
        }

        userInfoService.update(userInfo);
        return R.ok();
    }


}
