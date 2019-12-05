package com.codegym.penzuproject.service.Impl;

import com.codegym.penzuproject.model.Image;
import com.codegym.penzuproject.repository.IImageRepository;
import com.codegym.penzuproject.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ImageServiceImpl implements IImageService {
    @Autowired
    private IImageRepository repository;

    @Override
    public Optional<Image> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Image> findAll() {
        return repository.findAll();
    }

    @Override
    public Image save(Image image) {
        return repository.save(image);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
