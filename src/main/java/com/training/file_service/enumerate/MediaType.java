package com.training.file_service.enumerate;

import lombok.Getter;

@Getter
public enum MediaType {
    IMAGE("images"),
    VIDEO("videos"),
    FILE("files"),
    ;
    private final String path;

    MediaType(String path) {
        this.path = path;
    }
}
