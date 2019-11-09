package com.uh.server.persistence.jpa;

import org.springframework.data.repository.CrudRepository;

public interface CollectionItemRepository extends CrudRepository<CollectionItemEntity, Long> {
    
}
