package com.codegym.penzuproject.repository;

import com.codegym.penzuproject.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image,Long> {
    Iterable<Image> findImagesByAlbumId(Long id);
}
