package com.training.file_service.controller;

import com.training.file_service.model.FileInfo;
import com.training.file_service.model.UploadByFile;
import com.training.file_service.model.UploadByLink;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/files/")
public interface IFileController {

    @GetMapping("list")
    ResponseEntity<List<FileInfo>> getList();

    @PostMapping(value = "upload-by-link")
    ResponseEntity<FileInfo> uploadByLink(@RequestBody @Valid UploadByLink request);

    @PostMapping(value = "upload-by-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<FileInfo> uploadByFile(@ModelAttribute @Valid UploadByFile request);
}
