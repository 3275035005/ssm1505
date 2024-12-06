package com.cinema.service.impl;

import com.cinema.entity.FilmClassification;
import com.cinema.mapper.FilmClassificationMapper;
import com.cinema.service.FilmClassificationService;
import com.cinema.utils.PageResult;
import com.cinema.utils.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmClassificationServiceImpl implements FilmClassificationService {

    @Autowired
    private FilmClassificationMapper filmClassificationMapper;


    @Override
    public PageResult<FilmClassification> pageQuery(FilmClassification data, int current, int size) {
        PageHelper.startPage(current, size);
        List<FilmClassification> queryList = filmClassificationMapper.pageQuery(data);
        PageInfo<FilmClassification> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }

    @Override
    public int save(FilmClassification data) {
        data.setCreateTime(Util.getTime());
        return filmClassificationMapper.insert(data);
    }

    @Override
    public int update(FilmClassification data) {
        return filmClassificationMapper.update(data);
    }

    @Override
    public List<FilmClassification> getAll() {
        return filmClassificationMapper.getAll();
    }

    @Override
    public void delete(int id) {
        filmClassificationMapper.delete(id);
    }

    @Override
    public FilmClassification getById(Integer id) {
        return filmClassificationMapper.getById(id);
    }

    @Override
    public List<FilmClassification> getHabitList() {
        return filmClassificationMapper.getHabitList();
    }
}
