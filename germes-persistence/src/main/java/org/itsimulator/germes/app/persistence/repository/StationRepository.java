package org.itsimulator.germes.app.persistence.repository;

import org.itsimulator.germes.app.model.search.criteria.StationCriteria;

import java.util.List;

/**
 * Defines CRUD methods to access Station objects in the persistent storage
 * @author admin
 *
 */
public interface StationRepository {

    /**
     * Returns all the stations that match specified criteria
     * @param stationCriteria
     * @return
     */
    List findAllByCriteria(StationCriteria stationCriteria);

}
