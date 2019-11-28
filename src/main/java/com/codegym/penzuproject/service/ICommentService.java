package com.codegym.penzuproject.service;

import com.codegym.penzuproject.model.Comment;

import java.util.Optional;

public interface ICommentService {
    Optional<Comment> findById(Long id);

    Iterable<Comment> findAll();

    Comment save(Comment tag);

    void delete(Long id);

    Iterable<Comment> findCommentsByDiaryId(Long diary_id);
}
