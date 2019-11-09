package com.uh.server;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;
import uk.recurse.geocoding.reverse.Country;
import uk.recurse.geocoding.reverse.ReverseGeocoder;


public class ReverseGeocoderTest {

    @Test
    void testCoordinatesToCountryCode() {
        final String gpsPosition = "46.5662 12.6899888888889";
        final String[] s = StringUtils.split(gpsPosition, " ");
        if ((s == null) || (s.length != 2)) {
            Assertions.fail("GPS Position does not contain two doubles.");
        }

        final var x = s[0];
        final var y = s[1];

        final ReverseGeocoder geocoder = new ReverseGeocoder();
        final Optional<Country> country = geocoder.getCountry(Double.parseDouble(x), Double.parseDouble(y));

        Assertions.assertThat(country).isPresent();
        Assertions.assertThat(country.get().iso()).isEqualTo("IT");
        Assertions.assertThat(country.get().iso3()).isEqualTo("ITA");
        Assertions.assertThat(country.get().name()).isEqualTo("Italy");
        Assertions.assertThat(country.get().continent()).isEqualTo("EU");
    }

}
