package com.codegym.penzuproject.service;

import com.codegym.penzuproject.model.Album;

import java.util.Optional;

public interface IAlbumService {
    Optional<Album> findById(Long id);

    Iterable<Album> findAll();

    Album save(Album album);

    void delete(Long id);

    Iterable<Album> findAllByUserId(Long user_id);

    Iterable<Album> findAlbumsByTitleContaining(String title);

}
