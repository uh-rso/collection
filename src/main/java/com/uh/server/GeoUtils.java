package com.uh.server;

import java.util.Optional;

import com.uh.server.dto.CoordinatesDto;
import org.springframework.util.StringUtils;
import uk.recurse.geocoding.reverse.Country;
import uk.recurse.geocoding.reverse.ReverseGeocoder;

public class GeoUtils {

    public static CoordinatesDto getGpsCoordinates(final String gpsPosition) {
        final String[] s = StringUtils.split(gpsPosition, " ");
        if ((s == null) || (s.length != 2)) {
            throw new RuntimeException("GPS Position does not contain two doubles.");
        }
        return new CoordinatesDto(Double.parseDouble(s[0]), Double.parseDouble(s[1]));
    }

    public static Optional<Country> getCountryFromCoordinates(final CoordinatesDto coordinates) {
        final ReverseGeocoder geocoder = new ReverseGeocoder();
        final Optional<Country> country = geocoder.getCountry(coordinates.getLatitude(), coordinates.getLongitude());
        return country;
    }

    public static Optional<Country> getCountryFromCoordinates(final String gpsPosition) {
        final CoordinatesDto gpsCoordinates = getGpsCoordinates(gpsPosition);
        return getCountryFromCoordinates(gpsCoordinates);
    }

}
