package com.codegym.penzuproject.repository;

import com.codegym.penzuproject.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumRepository extends PagingAndSortingRepository<Album, Long> {
    Iterable<Album> findAllByUserId(Long user_id);

    Iterable<Album> findAlbumsByTitleContaining(String title);

    Page<Album> findAllByOrderByDateAsc(Pageable pageable);
    Page<Album> findAllByOrderByDateDesc(Pageable pageable);
}
