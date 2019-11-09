package com.uh.server.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class MediaIdDto implements Serializable {

    @JsonCreator
    public MediaIdDto() {}

    public MediaIdDto(final String id) {
        this.id = id;
    }

    private String id;
}
