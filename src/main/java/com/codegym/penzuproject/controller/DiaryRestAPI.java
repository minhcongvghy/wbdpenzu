package com.codegym.penzuproject.controller;

import com.codegym.penzuproject.message.request.SearchByTitleAndUserId;
import com.codegym.penzuproject.model.Diary;
import com.codegym.penzuproject.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class DiaryRestAPI {

    @Autowired
    private IDiaryService diaryService;

    @GetMapping("/diary/pagination")
    public ResponseEntity<?> getListDiaryAndPagination(@PageableDefault(value = 2) Pageable pageable) {
        Page<Diary> diaries =  diaryService.findAll(pageable);

        if (diaries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(diaries, HttpStatus.OK);
    }

    @GetMapping("/diary")
    public ResponseEntity<?> getListDiary() {
        List<Diary> diaries = (List<Diary>) diaryService.findAll();
        if(diaries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(diaries,HttpStatus.OK);
    }

    @GetMapping("/diary/{id}")
    public ResponseEntity<?> getDiary(@PathVariable Long id) {
        Optional<Diary> diary = diaryService.findById(id);

        if (!diary.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(diary, HttpStatus.OK);
    }

    @PostMapping("/diary")
    public ResponseEntity<?> createDiary(@Valid @RequestBody Diary diary) {

        LocalDate date = LocalDate.now();

        diary.setDate(date);
        diary.setUpdate(false);
        diaryService.save(diary);

        return new ResponseEntity<>(diary, HttpStatus.CREATED);
    }

    @PutMapping("/diary/{id}")
    public ResponseEntity<?> updateDiary(@Valid @RequestBody Diary diary, @PathVariable Long id) {
        Optional<Diary> diary1 = diaryService.findById(id);

        if (!diary1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        LocalDate date = LocalDate.now();
        diary1.get().setDate(date);
        diary1.get().setTitle(diary.getTitle());
        diary1.get().setDescription(diary.getDescription());
        diary1.get().setContent(diary.getContent());
        diary1.get().setUpdate(true);
        diary1.get().setTag(diary.getTag());
        diary1.get().setUser(diary.getUser());

        diaryService.save(diary1.get());

        return new ResponseEntity<>(diary1, HttpStatus.OK);
    }

    @DeleteMapping("/diary/{id}")
    public ResponseEntity<?> deleteDiary(@PathVariable Long id) {
        Optional<Diary> diary = diaryService.findById(id);

        if (!diary.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        diaryService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/diary/searchBy-Title-And-UserId")
    public ResponseEntity<?> searchDiaryByTitle(@RequestBody SearchByTitleAndUserId searchByTitleAndUserId) {
        List<Diary> diaries;
        if(searchByTitleAndUserId.getTitle() == "") {
            diaries = (List<Diary>) diaryService.findAll();
            if(diaries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(diaries,HttpStatus.OK);
        }
        diaries = (List<Diary>) diaryService.findDiariesByTitleContainingAndUserId(searchByTitleAndUserId.getTitle(),searchByTitleAndUserId.getId());
        return new ResponseEntity<>(diaries,HttpStatus.OK);
    }

    @GetMapping("/diary/searchBy-TagId/{id}")
    public ResponseEntity<?> searchByTagId(@PathVariable Long id) {
        List<Diary> diaries = (List<Diary>) diaryService.findDiariesByTagId(id);

        if (diaries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(diaries,HttpStatus.OK);
    }
}
