package com.cinema.service;

import com.cinema.entity.FilmClassification;

import java.util.List;

public interface FilmClassificationService extends BaseService<FilmClassification>{

    List<FilmClassification> getHabitList();

}
