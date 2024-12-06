package com.cinema.service.impl;

import com.cinema.entity.PlayScheduleInfo;
import com.cinema.mapper.PlayScheduleInfoMapper;
import com.cinema.service.FilmInfoService;
import com.cinema.service.PlayScheduleInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayScheduleInfoServiceImpl implements PlayScheduleInfoService {

    @Autowired
    private PlayScheduleInfoMapper playScheduleInfoMapper;
    @Override
    public PageResult<PlayScheduleInfo> pageQuery(PlayScheduleInfo data, int current, int size) {
        return null;
    }

    @Override

    public int save(PlayScheduleInfo data) {
        data.setCreateTime(Util.getTime());
        return playScheduleInfoMapper.insert(data);
    }

    @Override
    public int update(PlayScheduleInfo data) {
        return playScheduleInfoMapper.update(data);
    }

    @Override
    public List<PlayScheduleInfo> getAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public PlayScheduleInfo getById(Integer id) {
        return null;
    }

    @Override
    public PlayScheduleInfo getPlayScheduleByUidAndFId(Integer uid, Integer fid) {
        return playScheduleInfoMapper.getPlayScheduleByUidAndFId(uid, fid);
    }

    @Override
    public List<PlayScheduleInfo> getPlayScheduleListByUid(Integer uid) {
        return playScheduleInfoMapper.getPlayScheduleListByUid(uid);
    }
}
