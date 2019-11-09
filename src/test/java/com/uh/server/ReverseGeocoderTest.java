package com.uh.server;

import java.util.Optional;

import com.uh.server.dto.CoordinatesDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.recurse.geocoding.reverse.Country;
import uk.recurse.geocoding.reverse.ReverseGeocoder;


public class ReverseGeocoderTest {

    @Test
    void testCoordinatesToCountryCode() {
        final String gpsPosition = "46.5662 12.6899888888889";
        final CoordinatesDto gpsCoordinates = GeoUtils.getGpsCoordinates(gpsPosition);

        final ReverseGeocoder geocoder = new ReverseGeocoder();
        final Optional<Country> country = geocoder.getCountry(gpsCoordinates.getLatitude(), gpsCoordinates.getLongitude());

        Assertions.assertThat(country).isPresent();
        Assertions.assertThat(country.get().iso()).isEqualTo("IT");
        Assertions.assertThat(country.get().iso3()).isEqualTo("ITA");
        Assertions.assertThat(country.get().name()).isEqualTo("Italy");
        Assertions.assertThat(country.get().continent()).isEqualTo("EU");
    }

}
