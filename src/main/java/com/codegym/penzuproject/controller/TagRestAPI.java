package com.codegym.penzuproject.controller;

import com.codegym.penzuproject.model.Tag;
import com.codegym.penzuproject.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class TagRestAPI {
    @Autowired
    private ITagService tagService;

    @GetMapping("/tag")
    public ResponseEntity<?> getListAllTag() {
        List<Tag> tagList = (List<Tag>) tagService.findAll();

        if(tagList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tagList,HttpStatus.OK);
    }
}
