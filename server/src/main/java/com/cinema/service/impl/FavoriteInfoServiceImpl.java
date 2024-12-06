package com.cinema.service.impl;

import com.cinema.entity.FavoriteInfo;
import com.cinema.entity.FeedbackInfo;
import com.cinema.mapper.FavoriteInfoMapper;
import com.cinema.mapper.FeedbackInfoMapper;
import com.cinema.service.FavoriteInfoService;
import com.cinema.service.FeedbackInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteInfoServiceImpl implements FavoriteInfoService {

    @Autowired
    private FavoriteInfoMapper favoriteInfoMapper;


    @Override
    public PageResult<FavoriteInfo> pageQuery(FavoriteInfo data, int current, int size) {
        return null;
    }

    @Override
    public int save(FavoriteInfo data) {
        data.setCreateTime(Util.getTime());
        return favoriteInfoMapper.insert(data);
    }

    @Override
    public int update(FavoriteInfo data) {
        return favoriteInfoMapper.update(data);
    }

    @Override
    public List<FavoriteInfo> getAll() {
        return null;
    }

    @Override
    public void delete(int id) {
        favoriteInfoMapper.delete(id);
    }

    @Override
    public FavoriteInfo getById(Integer id) {
        return favoriteInfoMapper.getById(id);
    }

    @Override
    public boolean getByUidAndFid(int uid, int fid) {
        FavoriteInfo favoriteInfo = favoriteInfoMapper.getByUidAndFid(uid, fid);
        return favoriteInfo != null;
    }

    @Override
    public void deleteByUidAndFid(int uid, int fid) {
        favoriteInfoMapper.deleteByUidAndFid(uid, fid);
    }

    @Override
    public List<FavoriteInfo> getFavoriteInfoListByUid(int uid) {
        return favoriteInfoMapper.getFavoriteInfoListByUid(uid);
    }
}
