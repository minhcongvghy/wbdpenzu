package com.codegym.penzuproject.repository;

import com.codegym.penzuproject.model.Diary;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiaryRepository extends PagingAndSortingRepository<Diary,Long> {
    Iterable<Diary> findDiariesByUserId(Long user_id);
    Iterable<Diary> findDiariesByTitleContainingAndUserId(String title,Long user_id);
}
