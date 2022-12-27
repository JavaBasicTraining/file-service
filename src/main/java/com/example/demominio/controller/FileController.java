package com.example.demominio.controller;

import com.example.demominio.model.FileInfo;
import com.example.demominio.model.UploadByFile;
import com.example.demominio.model.UploadByLink;
import com.example.demominio.service.IMinioService;
import io.minio.errors.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class FileController implements IFileController {
    private final IMinioService iMinioService;

    public FileController(IMinioService iMinioService) {
        this.iMinioService = iMinioService;
    }

    @Override
    public ResponseEntity<List<FileInfo>> getList() {
        return ResponseEntity.ok(iMinioService.getList());
    }

    @Override
    public ResponseEntity<String> uploadByLink(UploadByLink request) {
        try {
            return ResponseEntity.ok(
                    iMinioService.uploadByLink(
                            request.getLink(),
                            request.getPath()
                    )
            );
        } catch (IOException | ServerException | InsufficientDataException | ErrorResponseException |
                 NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                 InternalException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<String> uploadByFile(UploadByFile request) {
        try {
            return ResponseEntity.ok(
                    iMinioService.uploadByFile(
                            request.getFile(),
                            request.getPath()
                    )
            );
        } catch (IOException | ServerException | InsufficientDataException | ErrorResponseException |
                 NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                 InternalException e) {
            throw new RuntimeException(e);
        }
    }

}
