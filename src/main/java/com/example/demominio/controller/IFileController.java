package com.example.demominio.controller;

import com.example.demominio.model.FileInfo;
import com.example.demominio.model.UploadByFile;
import com.example.demominio.model.UploadByLink;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/files/")
public interface IFileController {

    @GetMapping("list")
    ResponseEntity<List<FileInfo>> getList();

    @PostMapping("upload-by-link")
    ResponseEntity<String> uploadByLink(@RequestBody UploadByLink request);

    @PostMapping(value = "upload-by-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<String> uploadByFile(@ModelAttribute @Valid UploadByFile request);
}
