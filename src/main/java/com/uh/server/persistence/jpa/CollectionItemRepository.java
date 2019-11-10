package com.uh.server.persistence.jpa;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CollectionItemRepository extends CrudRepository<CollectionItemEntity, Long> {

    Optional<CollectionItemEntity> findByMediaId(final String mediaId);

}
