package com.cinema.service;

import com.cinema.entity.FilmList;

import java.util.List;

public interface FilmListService extends BaseService<FilmList>{

    List<FilmList> getByType(String type);
}
