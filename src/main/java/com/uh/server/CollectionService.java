package com.uh.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.uh.server.dto.CollectionDto;
import com.uh.server.dto.MediaDto;
import com.uh.server.dto.MediaIdDto;
import com.uh.server.persistence.jpa.CollectionEntity;
import com.uh.server.persistence.jpa.CollectionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public CollectionService(final CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<CollectionDto> getAll(final String userId) {
        final Set<CollectionEntity> byOwnerId = collectionRepository.findByOwnerId(userId);
        return byOwnerId.stream().map(x -> {
            var collection = new CollectionDto();
            collection.setOwnerId(x.getOwnerId());
            collection.setName(x.getName());
            collection.setMedia(
                    x.getItems().stream().map(y -> new MediaIdDto(y.getMediaId())).collect(Collectors.toList())
            );
            return collection;
        }).collect(Collectors.toList());
    }

}
