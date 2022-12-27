package com.example.demominio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadByFile implements Serializable {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private transient MultipartFile file;
    private String path;
}
