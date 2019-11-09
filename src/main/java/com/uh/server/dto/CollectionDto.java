package com.uh.server.dto;

import java.util.List;

import lombok.Data;

@Data
public class CollectionDto {
    private String name;
    private String ownerId;
    private List<MediaIdDto> media;
}
