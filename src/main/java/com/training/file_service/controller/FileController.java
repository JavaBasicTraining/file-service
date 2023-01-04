package com.training.file_service.controller;

import com.training.file_service.model.FileInfo;
import com.training.file_service.model.UploadByFile;
import com.training.file_service.model.UploadByLink;
import com.training.file_service.service.IMinioService;
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
    public ResponseEntity<FileInfo> uploadByLink(UploadByLink request) {
        try {
            return ResponseEntity.ok(
                    iMinioService.uploadByLink(
                            request.getLink(),
                            request.getType().getPath()
                    )
            );
        } catch (IOException | ServerException | InsufficientDataException | ErrorResponseException |
                 NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                 InternalException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<FileInfo> uploadByFile(UploadByFile request) {
        try {
            return ResponseEntity.ok(
                    iMinioService.uploadByFile(
                            request.getFile(),
                            request.getType().getPath()
                    )
            );
        } catch (IOException | ServerException | InsufficientDataException | ErrorResponseException |
                 NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                 InternalException e) {
            throw new RuntimeException(e);
        }
    }

}
