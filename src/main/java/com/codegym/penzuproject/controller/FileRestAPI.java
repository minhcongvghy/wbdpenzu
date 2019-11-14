package com.codegym.penzuproject.controller;

import com.codegym.penzuproject.message.request.FileForm;
import com.codegym.penzuproject.message.response.ResponseMessage;
import com.codegym.penzuproject.model.Diary;
import com.codegym.penzuproject.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class FileRestAPI {
    @Autowired
    private IDiaryService diaryService;

    @Autowired
    Environment env;

    @PostMapping(value = "/file/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<?> uploadFile(@ModelAttribute FileForm fileForm, BindingResult result, @PathVariable Long id) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(new ResponseMessage("Upload File Fail!"),HttpStatus.BAD_REQUEST);
        }

        MultipartFile multipartFile = fileForm.getFile();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        try {
            FileCopyUtils.copy(fileForm.getFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Optional<Diary> diary = diaryService.findById(id);
        if(!diary.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        diary.get().setFile(fileName);
        diaryService.save(diary.get());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}