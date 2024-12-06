package com.cinema.mapper;

import com.cinema.entity.FilmClassification;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FilmClassificationMapper继承基类
 */
@Repository
public interface FilmClassificationMapper extends BaseMapper<FilmClassification> {
    List<FilmClassification> getHabitList();

}
