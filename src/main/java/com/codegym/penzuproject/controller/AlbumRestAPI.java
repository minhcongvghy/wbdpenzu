package com.codegym.penzuproject.controller;

import com.codegym.penzuproject.model.Album;
import com.codegym.penzuproject.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AlbumRestAPI {

    @Autowired
    private IAlbumService albumService;

    @GetMapping("/album")
    public ResponseEntity<?> getAllAlbum() {
        List<Album> albums = (List<Album>) albumService.findAll();

        if (albums.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(albums,HttpStatus.OK);
    }

    @GetMapping("/album/{id}")
    public ResponseEntity<?> getAlbumById(@PathVariable Long id) {
        Optional<Album> album = albumService.findById(id);

        if (!album.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(album,HttpStatus.OK);
    }




}
