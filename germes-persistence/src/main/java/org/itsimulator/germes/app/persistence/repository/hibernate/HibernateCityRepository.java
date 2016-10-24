package org.itsimulator.germes.app.persistence.repository.hibernate;

import org.hibernate.SessionFactory;
import org.itsimulator.germes.app.persistence.hibernate.SessionFactoryBuilder;

import javax.inject.Inject;

/**
 * Created by Arthur on 24.10.2016.
 */
public class HibernateCityRepository {

    private final SessionFactory sessionFactory;

    @Inject
    public HibernateCityRepository(SessionFactoryBuilder builder) {
        sessionFactory = builder.getSessionFactory();
    }
}
