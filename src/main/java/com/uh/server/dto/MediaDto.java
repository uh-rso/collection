package com.uh.server.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class MediaDto implements Serializable {

    @JsonCreator
    public MediaDto() {}

    public MediaDto(final String id) {
        this.id = id;
    }

    private String id;
    private String originalFilename;
    private Map<String, String> tags;
    private String contentType;
    private String ownerId;
    private LocalDateTime createDateTime;
}
