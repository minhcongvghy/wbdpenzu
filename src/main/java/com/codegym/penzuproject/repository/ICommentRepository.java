package com.codegym.penzuproject.repository;

import com.codegym.penzuproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment,Long> {
    Iterable<Comment> findAllByDiaryId(Long diary_id);
}
