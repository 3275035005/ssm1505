package com.cinema.service.impl;

import com.cinema.entity.BannerInfo;
import com.cinema.mapper.BannerInfoMapper;
import com.cinema.service.BannerInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerInfoServiceImpl implements BannerInfoService {

    @Autowired
    private BannerInfoMapper bannerInfoMapper;


    @Override
    public PageResult<BannerInfo> pageQuery(BannerInfo data, int current, int size) {
        PageHelper.startPage(current, size);
        List<BannerInfo> queryList = bannerInfoMapper.pageQuery(data);
        PageInfo<BannerInfo> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }

    @Override
    public int save(BannerInfo data) {
        data.setCreateTime(Util.getTime());
        return bannerInfoMapper.insert(data);
    }

    @Override
    public int update(BannerInfo data) {
        return bannerInfoMapper.update(data);
    }

    @Override
    public List<BannerInfo> getAll() {
        return bannerInfoMapper.getAll();
    }

    @Override
    public void delete(int id) {
        bannerInfoMapper.delete(id);
    }
    
    @Override
    public BannerInfo getById(Integer id) {
        return bannerInfoMapper.getById(id);
    }
}
