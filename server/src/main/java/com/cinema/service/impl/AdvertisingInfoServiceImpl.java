package com.cinema.service.impl;

import com.cinema.entity.AdvertisingInfo;
import com.cinema.entity.AdvertisingInfo;
import com.cinema.mapper.AdvertisingInfoMapper;
import com.cinema.mapper.AdvertisingInfoMapper;
import com.cinema.service.AdvertisingInfoService;
import com.cinema.service.AdvertisingInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisingInfoServiceImpl implements AdvertisingInfoService {

    @Autowired
    private AdvertisingInfoMapper advertisingInfoMapper;


    @Override
    public PageResult<AdvertisingInfo> pageQuery(AdvertisingInfo data, int current, int size) {
        PageHelper.startPage(current, size);
        List<AdvertisingInfo> queryList = advertisingInfoMapper.pageQuery(data);
        PageInfo<AdvertisingInfo> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }

    @Override
    public int save(AdvertisingInfo data) {
        data.setCreateTime(Util.getTime());
        return advertisingInfoMapper.insert(data);
    }

    @Override
    public int update(AdvertisingInfo data) {
        return advertisingInfoMapper.update(data);
    }

    @Override
    public List<AdvertisingInfo> getAll() {
        return advertisingInfoMapper.getAll();
    }

    @Override
    public void delete(int id) {
        advertisingInfoMapper.delete(id);
    }

    @Override
    public AdvertisingInfo getById(Integer id) {
        return advertisingInfoMapper.getById(id);
    }
}
