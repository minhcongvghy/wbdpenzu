package com.codegym.penzuproject.repository;

import com.codegym.penzuproject.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IDiaryRepository extends JpaRepository<Diary,Long> {
    Iterable<Diary> findDiariesByUserId(Long user_id);
}
