package com.clothes.utils;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;
    //private static final EntityManagerFactory entityManagerFactory;
    private static final Logger logger = Logger.getLogger(HibernateUtil.class);
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            logger.debug("Creating the cofiguration..");
            Configuration configuration = new Configuration();
            configuration.configure();
            logger.debug("Cogigured!");
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();
            logger.debug("Building ServiceRegistry..");
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            logger.debug("SessionFactory was built!");
        } catch (Throwable ex) {
            logger.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null)
            sessionFactory.close();
    }

//    public static EntityManager getEntityManager(){
//        return entityManagerFactory.createEntityManager();
//    }
}