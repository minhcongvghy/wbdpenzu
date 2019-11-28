package com.codegym.penzuproject.service.Impl;

import com.codegym.penzuproject.model.Comment;
import com.codegym.penzuproject.repository.ICommentRepository;
import com.codegym.penzuproject.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {
   @Autowired
   private ICommentRepository repository;

    @Override
    public Optional<Comment> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public Comment save(Comment tag) {
        return repository.saveAndFlush(tag);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Comment> findCommentsByDiaryId(Long diary_id) {
        return repository.findCommentsByDiaryId(diary_id);
    }


}
