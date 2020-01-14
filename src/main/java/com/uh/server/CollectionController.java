package com.uh.server;

import java.util.List;

import com.uh.server.dto.CollectionDto;
import com.uh.server.dto.MediaDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/collections")
public class CollectionController {

    private final CollectionService collectionService;

    private final MediaHandler mediaHandler;

    public CollectionController(final CollectionService collectionService, final MediaHandler mediaHandler) {
        this.collectionService = collectionService;
        this.mediaHandler = mediaHandler;
    }

    @PostMapping(path = "/media")
    public void newMediaCreated(@RequestBody final MediaDto media) {
        final String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        mediaHandler.newMediaCreated(media, userId);
    }

    @GetMapping
    public List<CollectionDto> getAll() {
        final String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return collectionService.getAll(userId);
    }

}
