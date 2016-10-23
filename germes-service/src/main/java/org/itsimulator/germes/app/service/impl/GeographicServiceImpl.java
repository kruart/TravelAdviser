package org.itsimulator.germes.app.service.impl;

import org.itsimulator.germes.app.model.entity.geography.City;
import org.itsimulator.germes.app.model.entity.geography.Station;
import org.itsimulator.germes.app.model.search.criteria.StationCriteria;
import org.itsimulator.germes.app.model.search.criteria.range.RangeCriteria;
import org.itsimulator.germes.app.persistence.repository.CityRepository;
import org.itsimulator.germes.app.service.GeographicService;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Default implementation of the {@link GeographicService}
 *
 * @author admin
 *
 */
public class GeographicServiceImpl implements GeographicService {
    private CityRepository cityRepository;

    @Inject
    public GeographicServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> findCities() {
        return cityRepository.findAll();
    }

    @Override
    public void saveCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public Optional<City> findCityById(int id) {
        return Optional.ofNullable(cityRepository.findById(id));
    }

    @Override
    public List<Station> searchStations(final StationCriteria criteria, final RangeCriteria rangeCriteria) {
        Set<Station> stations = new HashSet<>();

        cityRepository.findAll().forEach(city -> stations.addAll(city.getStations()));

        return stations.stream().filter(station -> station.match(criteria)).collect(Collectors.toList());
    }
}
