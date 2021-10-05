package com.Helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {

	public static SessionFactory factory;

	public static SessionFactory getFactory() {
		if (factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}

	public void closeFactory() {
		if (factory.isOpen()) {
			factory.close();
		}
	}
}

// Humne static SessionFactory isi liye declared kiya he ki   hume direct method call kr skte he. Naaki object create krke method call kro