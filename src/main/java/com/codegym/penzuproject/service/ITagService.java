package com.codegym.penzuproject.service;

import com.codegym.penzuproject.model.Tag;

import java.util.Optional;

public interface ITagService {
    Optional<Tag> findById(Long id);

    Iterable<Tag> findAll();

    Tag save(Tag tag);

    void delete(Long id);
}
