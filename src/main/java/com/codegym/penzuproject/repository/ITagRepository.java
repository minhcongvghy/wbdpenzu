package com.codegym.penzuproject.repository;

import com.codegym.penzuproject.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITagRepository extends JpaRepository<Tag,Long> {
}
