package org.itsimulator.germes.app.model.entity.geography;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Contains unit-tests to check functionality of {@link City} class
 * @author admin
 */
public class CityTest {
    private City city;

    @Before
    public void setup() {
        city = new City();
    }

    @Test
    public void testAddValidStationSuccess() {
        Station station = new Station();

        city.addStation(station);

        assertTrue(containsStation(city, station));
        assertEquals(city, station.getCity());
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullStationFailure() {
        city.addStation(null);

        assertTrue(false);
    }

    @Test
    public void testAddDuplicateStationFailure() {
        Station station = new Station();

        city.addStation(station);
        city.addStation(station);

        assertEquals(city.getStations().size(), 1);
    }

    @Test
    public void testRemoveStationSuccess() {
        Station station = new Station();
        city.addStation(station);

        city.removeStation(station);

        assertTrue(city.getStations().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveStationFailure() {
        city.removeStation(null);

        assertTrue(false);
    }

    private boolean containsStation(City city, Station station) {
        return city.getStations().contains(station);
    }


}