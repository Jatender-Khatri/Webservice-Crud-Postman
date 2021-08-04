package com.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Connections {
	private static SessionFactory factory = null;

	public static SessionFactory getConnection() {

		if (factory == null) {

			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

			Metadata meta = (Metadata) new MetadataSources(ssr).getMetadataBuilder().build();

			factory = ((org.hibernate.boot.Metadata) meta).getSessionFactoryBuilder().build();

		}

		return factory;
	}

}
