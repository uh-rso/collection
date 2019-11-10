package com.uh.server;

import java.util.Optional;

import com.uh.server.dto.MediaDto;
import com.uh.server.persistence.jpa.CollectionEntity;
import com.uh.server.persistence.jpa.CollectionItemEntity;
import com.uh.server.persistence.jpa.CollectionItemRepository;
import com.uh.server.persistence.jpa.CollectionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uk.recurse.geocoding.reverse.Country;

@Component
@Transactional
public class MediaHandler {

    private final CollectionRepository collectionRepository;
    private final CollectionItemRepository collectionItemRepository;

    public MediaHandler(
            final CollectionRepository collectionRepository,
            final CollectionItemRepository collectionItemRepository) {
        this.collectionRepository = collectionRepository;
        this.collectionItemRepository = collectionItemRepository;
    }


    public void newMediaCreated(final MediaDto media) {
        final String gpsPosition = media.getTags().get("GPSPosition");
        final Optional<Country> countryFromCoordinates = GeoUtils.getCountryFromCoordinates(gpsPosition);

        if (countryFromCoordinates.isEmpty()) {
            return;
        }

        final var country = countryFromCoordinates.get();
        final String countryName = country.name();

        //
        Optional<CollectionEntity> countryByName = collectionRepository.findByName(countryName);

        final CollectionEntity countryCollection;
        if (countryByName.isEmpty()) {
            countryCollection = new CollectionEntity();
            countryCollection.setOwnerId("1"); // TODO Inject authenticated userId or ownerId
            countryCollection.setName(countryName);
            collectionRepository.save(countryCollection);
        } else {
            countryCollection = countryByName.get();
        }

        final Optional<CollectionItemEntity> byId = collectionItemRepository.findById(Long.valueOf(media.getId()));
        final CollectionItemEntity item = byId.isEmpty() ? new CollectionItemEntity() : byId.get();
        item.setCollection(countryCollection);
        item.setMediaId(media.getId());
        collectionItemRepository.save(item);
    }



}
