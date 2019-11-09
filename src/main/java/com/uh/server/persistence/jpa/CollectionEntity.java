package com.uh.server.persistence.jpa;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class CollectionEntity {

    @Id
    @GeneratedValue
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "collection")
    private Set<CollectionItemEntity> items = new HashSet<>();

    @Getter
    @Setter
    private String ownerId;

    @CreationTimestamp
    @Getter
    @Setter
    private LocalDateTime createDateTime;

}
