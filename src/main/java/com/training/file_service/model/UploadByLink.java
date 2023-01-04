package com.training.file_service.model;

import com.training.file_service.enumerate.MediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UploadByLink {

    @NotNull
    private String link;

    @NotNull
    @Builder.Default
    private MediaType type = MediaType.FILE;
}
