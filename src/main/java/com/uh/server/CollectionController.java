package com.uh.server;

import java.util.List;

import com.uh.server.dto.CollectionDto;
import com.uh.server.dto.MediaDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/collections")
public class CollectionController {

    private final CollectionService collectionService;

    private final MediaHandler mediaHandler;

    private final String userId = "1";

    public CollectionController(final CollectionService collectionService, final MediaHandler mediaHandler) {
        this.collectionService = collectionService;
        this.mediaHandler = mediaHandler;
    }

    @PostMapping(path = "/media")
    public void newMediaCreated(@RequestBody final MediaDto media) {
        mediaHandler.newMediaCreated(media);
    }

    @GetMapping
    public List<CollectionDto> getAll() {
        return collectionService.getAll("1"); // TODO Fix userId/ownerId
    }

}
