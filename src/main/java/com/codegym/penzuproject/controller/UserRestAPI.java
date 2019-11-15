package com.codegym.penzuproject.controller;

import com.codegym.penzuproject.model.Diary;
import com.codegym.penzuproject.model.User;
import com.codegym.penzuproject.service.IDiaryService;
import com.codegym.penzuproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class UserRestAPI {
    @Autowired
    private IUserService userService;

    @Autowired
    private IDiaryService diaryService;

    @GetMapping("/user")
    public ResponseEntity<?> getListAllUser(){
        List<User> users = (List<User>) userService.findAll();

        if(users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);

        if(!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id ){
        Optional<User> user = userService.findById(id);

        if(!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{id}/diary")
    public ResponseEntity<?> getAllDiaryByUser(@PathVariable Long id) {
        List<Diary> diaries = (List<Diary>) diaryService.findDiariesByUserId(id);

        if(diaries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(diaries,HttpStatus.OK);
    }
}
