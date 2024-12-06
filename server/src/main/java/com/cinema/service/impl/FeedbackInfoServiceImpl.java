package com.cinema.service.impl;

import com.cinema.entity.FeedbackInfo;
import com.cinema.mapper.FeedbackInfoMapper;
import com.cinema.service.FeedbackInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackInfoServiceImpl implements FeedbackInfoService {

    @Autowired
    private FeedbackInfoMapper feedbackInfoMapper;


    @Override
    public PageResult<FeedbackInfo> pageQuery(FeedbackInfo data, int current, int size) {
        PageHelper.startPage(current, size);
        List<FeedbackInfo> queryList = feedbackInfoMapper.pageQuery(data);
        PageInfo<FeedbackInfo> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }

    @Override
    public int save(FeedbackInfo data) {
        data.setCreateTime(Util.getTime());
        return feedbackInfoMapper.insert(data);
    }

    @Override
    public int update(FeedbackInfo data) {
        return feedbackInfoMapper.update(data);
    }

    @Override
    public List<FeedbackInfo> getAll() {
        return feedbackInfoMapper.getAll();
    }

    @Override
    public void delete(int id) {
        feedbackInfoMapper.delete(id);
    }

    @Override
    public FeedbackInfo getById(Integer id) {
        return feedbackInfoMapper.getById(id);
    }
}
