package com.codegym.penzuproject.service.Impl;

import com.codegym.penzuproject.model.Diary;
import com.codegym.penzuproject.repository.IDiaryRepository;
import com.codegym.penzuproject.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DiaryServiceImpl implements IDiaryService {
    @Autowired
    private IDiaryRepository repository;

    @Override
    public Optional<Diary> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Diary> findAll() {
        return repository.findAll();
    }

    @Override
    public Diary save(Diary diary) {
        return repository.save(diary);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
