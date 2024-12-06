package com.cinema.service.impl;

import com.cinema.entity.FilmInfo;
import com.cinema.entity.UserInfo;
import com.cinema.mapper.FavoriteInfoMapper;
import com.cinema.mapper.FilmInfoMapper;
import com.cinema.service.FilmInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmInfoServiceImpl implements FilmInfoService {

    @Autowired
    private FilmInfoMapper filmInfoMapper;

    @Autowired
    private FavoriteInfoMapper favoriteInfoMapper;

    @Override
    public PageResult<FilmInfo> pageQuery(FilmInfo data, int current, int size) {
        PageHelper.startPage(current, size);
        List<FilmInfo> queryList = filmInfoMapper.pageQuery(data);
        PageInfo<FilmInfo> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }

    @Override
    public int save(FilmInfo data) {
        data.setCreateTime(Util.getTime());
        return filmInfoMapper.insert(data);
    }

    @Override
    public int update(FilmInfo data) {
        return filmInfoMapper.update(data);
    }

    @Override
    public List<FilmInfo> getAll() {
        return filmInfoMapper.getAll();
    }

    @Override
    public void delete(int id) {
        filmInfoMapper.delete(id);
    }

    @Override
    public FilmInfo getById(Integer id) {
        return filmInfoMapper.getById(id);
    }

    @Override
    public List<FilmInfo> getListByRecommendStatus(String recommendStatus) {
        return filmInfoMapper.getListByRecommendStatus(recommendStatus);
    }

    @Override
    public List<FilmInfo> getListByClassificationIdIsNotFilmInfoId(String classificationId, Integer filmInfoId) {
        return filmInfoMapper.getListByClassificationIdIsNotFilmInfoId(classificationId, filmInfoId);
    }

    @Override
    public List<FilmInfo> getListByClassificationIdAndTitle(Integer id, String title) {
        return filmInfoMapper.getListByClassificationIdAndTitle(id, title);

    }

    @Override
    public List<FilmInfo> getListFilmArithmetic(UserInfo userInfo) {

        List<FilmInfo> list = new ArrayList<>();
        if(userInfo != null){// 已登录根据自己收藏进行协同过滤
            // 根据收藏协同过滤数据
            List<Integer> fidList = favoriteInfoMapper.getFIdListByUid(userInfo.getId());
            if(fidList.size() < 5){//协同过滤5个数据，不满足查询同类型数据，直到5条数据
                // 获取相同分类的电影
                List<Integer> cId = favoriteInfoMapper.getCIdListByUid(userInfo.getId());

//                List<Integer> all = filmInfoMapper.getFidList();
//                all.removeIf(fidList::contains);
//                all.subList(0, 5 - fidList.size());
                if(cId.size() != 0){
                    list.addAll(filmInfoMapper.getFidListInfo(cId));
                }
            }
            list.addAll(filmInfoMapper.getFidListInfo(fidList));
        }else{  // 未登录根据所有收藏进行协同过滤
            // 获取所有用户收藏的数量前5的排行的电影信息
            List<Integer> fidList = favoriteInfoMapper.getFidList();
            if(fidList.size() < 5){//协同过滤5个数据，不满足5随机获取数据，直到5条数据
                List<Integer> all = filmInfoMapper.getFidList();
                all.removeIf(fidList::contains);
                all.subList(0, 4 - fidList.size());
                list.addAll(filmInfoMapper.getFidListInfo(fidList));
                list.addAll(filmInfoMapper.getFidListInfo(all));
            }else{
                list.addAll(filmInfoMapper.getFidListInfo(fidList));
            }
        }
        return list;
    }
}
