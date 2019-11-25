package com.codegym.penzuproject.service.Impl;

import com.codegym.penzuproject.model.Diary;
import com.codegym.penzuproject.repository.IDiaryRepository;
import com.codegym.penzuproject.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiaryServiceImpl implements IDiaryService {
    @Autowired
    private IDiaryRepository repository;

    @Override
    public Optional<Diary> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Diary> findAll() {
        return  repository.findAll();
    }

    @Override
    public Page<Diary> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Diary save(Diary diary) {
        return repository.save(diary);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Diary> findDiariesByUserId(Long user_id) {
        return repository.findDiariesByUserId(user_id);
    }

    @Override
    public Iterable<Diary> findDiariesByTitleContainingAndUserId(String title, Long user_id) {
        return repository.findDiariesByTitleContainingAndUserId(title,user_id);
    }

    @Override
    public Iterable<Diary> findDiariesByTagId(Long tag_id) {
        return repository.findDiariesByTagId(tag_id);
    }

    @Override
    public Iterable<Diary> findDiariesByTitleContaining(String title) {
        return repository.findDiariesByTitleContaining(title);
    }


}
