package com.codegym.penzuproject.repository;

import com.codegym.penzuproject.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumRepository extends JpaRepository<Album, Long> {
    Iterable<Album> findAllByUserId(Long user_id);
}
