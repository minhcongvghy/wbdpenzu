package com.codegym.penzuproject.service.Impl;

import com.codegym.penzuproject.model.Tag;
import com.codegym.penzuproject.repository.ITagRepository;
import com.codegym.penzuproject.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TagServiceImpl implements ITagService {
    @Autowired
    private ITagRepository repository;

    @Override
    public Optional<Tag> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Tag> findAll() {
        return repository.findAll();
    }

    @Override
    public Tag save(Tag tag) {
        return repository.save(tag);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
