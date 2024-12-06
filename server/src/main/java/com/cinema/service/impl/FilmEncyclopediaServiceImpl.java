package com.cinema.service.impl;

import com.cinema.entity.FilmEncyclopedia;
import com.cinema.mapper.FilmEncyclopediaMapper;
import com.cinema.service.FilmEncyclopediaService;
import com.cinema.utils.PageResult;
import com.cinema.utils.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmEncyclopediaServiceImpl implements FilmEncyclopediaService {

    @Autowired
    private FilmEncyclopediaMapper filmEncyclopediaMapper;


    @Override
    public PageResult<FilmEncyclopedia> pageQuery(FilmEncyclopedia data, int current, int size) {
        PageHelper.startPage(current, size);
        List<FilmEncyclopedia> queryList = filmEncyclopediaMapper.pageQuery(data);
        PageInfo<FilmEncyclopedia> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }

    @Override
    public int save(FilmEncyclopedia data) {
        data.setCreateTime(Util.getTime());
        return filmEncyclopediaMapper.insert(data);
    }

    @Override
    public int update(FilmEncyclopedia data) {
        return filmEncyclopediaMapper.update(data);
    }

    @Override
    public List<FilmEncyclopedia> getAll() {
        return filmEncyclopediaMapper.getAll();
    }

    @Override
    public void delete(int id) {
        filmEncyclopediaMapper.delete(id);
    }

    @Override
    public FilmEncyclopedia getById(Integer id) {
        return filmEncyclopediaMapper.getById(id);
    }
}
