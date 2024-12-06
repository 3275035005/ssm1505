package com.cinema.service.impl;

import com.cinema.entity.CommentInfo;
import com.cinema.entity.FavoriteInfo;
import com.cinema.mapper.CommentInfoMapper;
import com.cinema.mapper.FavoriteInfoMapper;
import com.cinema.service.CommentInfoService;
import com.cinema.service.FavoriteInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentInfoServiceImpl implements CommentInfoService {

    @Autowired
    private CommentInfoMapper commentInfoMapper;

    @Override
    public PageResult<CommentInfo> pageQuery(CommentInfo data, int current, int size) {
        return null;
    }

    @Override
    public int save(CommentInfo data) {
        data.setCreateTime(Util.getTime());
        return commentInfoMapper.insert(data);
    }

    @Override
    public int update(CommentInfo data) {
        return commentInfoMapper.update(data);
    }

    @Override
    public List<CommentInfo> getAll() {
        return commentInfoMapper.getAll();
    }

    @Override
    public void delete(int id) {
        commentInfoMapper.delete(id);
    }

    @Override
    public CommentInfo getById(Integer id) {
        return commentInfoMapper.getById(id);
    }

}
