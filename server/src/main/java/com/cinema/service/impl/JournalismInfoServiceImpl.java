package com.cinema.service.impl;

import com.cinema.entity.JournalismInfo;
import com.cinema.mapper.JournalismInfoMapper;
import com.cinema.service.JournalismInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalismInfoServiceImpl implements JournalismInfoService {

    @Autowired
    private JournalismInfoMapper journalismInfoMapper;


    @Override
    public PageResult<JournalismInfo> pageQuery(JournalismInfo data, int current, int size) {
        PageHelper.startPage(current, size);
        List<JournalismInfo> queryList = journalismInfoMapper.pageQuery(data);
        PageInfo<JournalismInfo> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }

    @Override
    public int save(JournalismInfo data) {
        data.setCreateTime(Util.getTime());
        return journalismInfoMapper.insert(data);
    }

    @Override
    public int update(JournalismInfo data) {
        return journalismInfoMapper.update(data);
    }

    @Override
    public List<JournalismInfo> getAll() {
        return journalismInfoMapper.getAll();
    }

    @Override
    public void delete(int id) {
        journalismInfoMapper.delete(id);
    }

    @Override
    public JournalismInfo getById(Integer id) {
        return journalismInfoMapper.getById(id);
    }
}
