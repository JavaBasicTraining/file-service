package com.training.file_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.training.file_service.enumerate.MediaType;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UploadByFile implements Serializable {

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private transient MultipartFile file;

    @Builder.Default
    @NotNull
    private MediaType type = MediaType.FILE;
}
