package com.cinema.service.impl;

import com.cinema.entity.FilmList;
import com.cinema.mapper.FilmListMapper;
import com.cinema.service.FilmListService;
import com.cinema.utils.PageResult;
import com.cinema.utils.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmListServiceImpl implements FilmListService {

    @Autowired
    private FilmListMapper filmListMapper;


    @Override
    public PageResult<FilmList> pageQuery(FilmList data, int current, int size) {
        PageHelper.startPage(current, size);
        List<FilmList> queryList = filmListMapper.pageQuery(data);
        PageInfo<FilmList> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }

    @Override
    public int save(FilmList data) {
        data.setCreateTime(Util.getTime());
        return filmListMapper.insert(data);
    }

    @Override
    public int update(FilmList data) {
        return filmListMapper.update(data);
    }

    @Override
    public List<FilmList> getAll() {
        return filmListMapper.getAll();
    }

    @Override
    public void delete(int id) {
        filmListMapper.delete(id);
    }

    @Override
    public FilmList getById(Integer id) {
        return filmListMapper.getById(id);
    }

    @Override
    public List<FilmList> getByType(String type) {
        return filmListMapper.getByType(type);
    }
}
