package com.uh.server.persistence.jpa;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends CrudRepository<CollectionEntity, Long> {

    Optional<CollectionEntity> findByName(final String name);

    Set<CollectionEntity> findByOwnerId(final String ownerId);

}
