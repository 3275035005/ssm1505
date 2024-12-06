package com.cinema.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.cinema.entity.UserInfo;
import com.cinema.mapper.UserInfoMapper;
import com.cinema.service.UserInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public PageResult<UserInfo> pageQuery(UserInfo data,int current, int size) {
        PageHelper.startPage(current, size);
        List<UserInfo> queryList = userInfoMapper.pageQuery(data);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }

    @Override
    public int save(UserInfo data) {
        data.setCreateTime(Util.getTime());
        return userInfoMapper.insert(data);
    }

    @Override
    public int update(UserInfo data) {
        return userInfoMapper.update(data);
    }

    @Override
    public List<UserInfo> getAll() {
        return userInfoMapper.getAll();
    }

    @Override
    public void delete(int id) {
        userInfoMapper.delete(id);
    }


    @Override
    public UserInfo getUserInfoByUsername(String username) {
        return userInfoMapper.getUserInfoByUsername(username);
    }

    @Override
    public UserInfo getById(Integer id) {
        return userInfoMapper.getById(id);
    }
}
