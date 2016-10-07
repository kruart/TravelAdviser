package org.itsimulator.germes.app.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.itsimulator.germes.app.infra.util.CommonUtil;
import org.itsimulator.germes.app.model.entity.geography.City;
import org.itsimulator.germes.app.model.entity.geography.Station;
import org.itsimulator.germes.app.model.search.criteria.StationCriteria;
import org.itsimulator.germes.app.model.search.criteria.range.RangeCriteria;
import org.itsimulator.germes.app.service.GeographicService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Default implementation of the {@link GeographicService}
 *
 * @author admin
 *
 */
public class GeographicServiceImpl implements GeographicService {
    /**
     * Internal list of cities
     */
    private final List<City> cities;

    /**
     * Auto-increment counter for entity id generation
     */
    private int counter = 0;

    public GeographicServiceImpl() {
        cities = new ArrayList<>();
    }

    @Override
    public List<City> findCities() {
        return CommonUtil.getSafeList(cities);
    }

    @Override
    public void saveCity(City city) {
        if(!cities.contains(city)) {
            city.setId(++counter);
            cities.add(city);
        }
    }

    @Override
    public Optional<City> findCityById(int id) {
        return cities.stream().filter((city) -> city.getId() == id).findFirst();
    }

    @Override
    public List<Station> searchStations(final StationCriteria criteria, final RangeCriteria rangeCriteria) {
        //get all cities which match satisfied specific criteria, if criteria are empty, then get all cities
        Stream<City> stream = cities.stream()
                .filter((city) -> StringUtils.isEmpty(criteria.getName()) || city.getName().equals(criteria.getName()));

        //get collection of all stations from stream above
        Optional<Set<Station>> stations = stream.map((city) -> city.getStations())
                .reduce((stations1, stations2) -> {
                    Set<Station> newStations = new HashSet<>(stations2);
                    newStations.addAll(stations1);
                    return newStations;
                });

        if (!stations.isPresent()) {
            return Collections.emptyList();
        }

        //filters the stations by transport type and return as List
        return stations.get()
                .stream()
                .filter((station) -> criteria.getTransportType() == null || station.getTransportType() == criteria.getTransportType())
                .collect(Collectors.toList());
    }
}
