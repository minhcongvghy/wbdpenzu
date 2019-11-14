package com.codegym.penzuproject.controller;

import com.codegym.penzuproject.message.response.ResponseMessage;
import com.codegym.penzuproject.model.Diary;
import com.codegym.penzuproject.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class DiaryRestAPI {

    @Autowired
    private IDiaryService diaryService;

    @GetMapping("/diary")
    public ResponseEntity<?> getListAllDiary() {
        List<Diary> diaries = (List<Diary>) diaryService.findAll();

        if(diaries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(diaries,HttpStatus.OK);
    }
}
