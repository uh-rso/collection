package com.uh.server.persistence.jpa;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class CollectionItemEntity {

    @Id
    @GeneratedValue
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CollectionEntity media;

    @Getter
    @Setter
    private String mediaId;

    @CreationTimestamp
    @Getter
    @Setter
    private LocalDateTime createDateTime;

}
