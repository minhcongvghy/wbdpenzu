package com.codegym.penzuproject.service;

import com.codegym.penzuproject.model.Diary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface IDiaryService {
    Optional<Diary> findById(Long id);

    Iterable<Diary> findAll();

    Page<Diary> findAll(Pageable pageable);

    Diary save(Diary diary);

    void delete(Long id);

    Iterable<Diary> findDiariesByUserId(Long user_id);

    Iterable<Diary> findDiariesByTitleContainingAndUserId(String title,Long user_id);

    Iterable<Diary> findDiariesByTagId(Long tag_id);
}
