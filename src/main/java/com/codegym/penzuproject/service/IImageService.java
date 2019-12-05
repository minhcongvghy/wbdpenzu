package com.codegym.penzuproject.service;

import com.codegym.penzuproject.model.Image;

import java.util.Optional;

public interface IImageService {
    Optional<Image> findById(Long id);

    Iterable<Image> findAll();

    Image save(Image image);

    void delete(Long id);
}
