package com.codegym.penzuproject.service;

import com.codegym.penzuproject.model.Diary;

import java.util.Optional;

public interface IDiaryService {
    Optional<Diary> findById(Long id);

    Iterable<Diary> findAll();

    Diary save(Diary diary);

    void delete(Long id);

    Iterable<Diary> findDiariesByUserId(Long user_id);

    Iterable<Diary> findDiariesByTitleContainingAndUserId(String title,Long user_id);
}
