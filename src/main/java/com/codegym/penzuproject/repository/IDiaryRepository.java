package com.codegym.penzuproject.repository;

import com.codegym.penzuproject.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiaryRepository extends JpaRepository<Diary,Long> {
    Iterable<Diary> findDiariesByUserId(Long user_id);
}
