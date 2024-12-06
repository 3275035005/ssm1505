package com.cinema.mapper;

import com.cinema.entity.FilmList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FilmListMapper继承基类
 */
@Repository
public interface FilmListMapper  extends BaseMapper<FilmList>{
    List<FilmList> getByType(String type);
}
