package com.codegym.penzuproject.controller;

import com.codegym.penzuproject.model.Diary;
import com.codegym.penzuproject.model.Tag;
import com.codegym.penzuproject.service.IDiaryService;
import com.codegym.penzuproject.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class TagRestAPI {
    @Autowired
    private ITagService tagService;

    @Autowired
    private IDiaryService diaryService;

    @GetMapping("/tag")
    public ResponseEntity<?> getListAllTag() {
        List<Tag> tagList = (List<Tag>) tagService.findAll();

        if(tagList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tagList,HttpStatus.OK);
    }

    @GetMapping("/tag/{id}")
    public ResponseEntity<?> getTag(@PathVariable Long id) {
        Optional<Tag> tag = tagService.findById(id);

        if (!tag.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tag,HttpStatus.OK);
    }

    @PostMapping("/tag")
    public ResponseEntity<?> createTag(@Valid @RequestBody Tag tag) {
        tagService.save(tag);

        return new ResponseEntity<>(tag,HttpStatus.CREATED);
    }

    @PutMapping("/tag/{id}")
    public ResponseEntity<?> updateTag(@Valid @RequestBody Tag tag, @PathVariable Long id) {
        Optional<Tag> tag1 = tagService.findById(id);
        if(!tag1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tag1.get().setName(tag.getName());
        tagService.save(tag1.get());

        return new ResponseEntity<>(tag1,HttpStatus.OK);
    }

    @DeleteMapping("/tag/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable Long id) {
        Optional<Tag> tag = tagService.findById(id);
        if(!tag.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Diary> diaries = (List<Diary>) diaryService.findDiariesByUserId(id);

        if(!diaries.isEmpty()) {
            for (Diary diary: diaries) {
                diaryService.delete(diary.getId());
            }
        }

        tagService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
