package com.codegnan.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConnectionFactoryHelper {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry registry =
                    new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            Metadata metadata =
                    new MetadataSources(registry)
                    .getMetadataBuilder()
                    .build();

            SessionFactoryBuilder builder =
                    metadata.getSessionFactoryBuilder();

            sessionFactory = builder.build();
        }
        return sessionFactory;
    }
}
