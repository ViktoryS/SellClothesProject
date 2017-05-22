package com.clothes.dao;

import com.clothes.model.Cloth;
import com.clothes.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ClothesStorage {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    //private static EntityManager entityManager = HibernateUtil.getEntityManager();
    private static Logger logger = Logger.getLogger(ClothesStorage.class);
    private static List<Cloth> clothes  = new ArrayList<Cloth>();

    static {
        initList();
    }

    private ClothesStorage() {}

    public static void initList(){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            logger.debug("Open session..");
            session.beginTransaction();
            logger.debug("Begin transaction");
            clothes = (List<Cloth>) session.createQuery("FROM Cloth").list();
            logger.debug("list of clothes was initialised");
            session.getTransaction().commit();
        }catch (Exception e){
            logger.error("Error of getting clothes from DB! " + e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    public static List<Cloth> getAllClothes() {
        initList();
        return clothes;
    }

    public static Cloth getCloth(long id) {
        for (Cloth cloth: clothes)
            if(cloth.getId() == id)
                return cloth;
        return null;
    }

    public static Cloth getCloth(String name) {
        for (Cloth cloth: clothes)
            if(name.equals(cloth.getName()))
                return cloth;
        return null;
    }

    public static void addCloth(Cloth cloth) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            logger.debug("Open session..");
            session.beginTransaction();
            logger.debug("Begin transaction");
            session.persist(cloth);
            logger.debug("New cloth was saved!");
            session.getTransaction().commit();
        }catch (Exception e){
            logger.error("Error of saving data to DB!  " + e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    public static boolean isEmpty() {
        return clothes.isEmpty();
    }

    public static boolean removeCloth(Cloth cloth){
        return clothes.remove(cloth);
    }

    public static List<Cloth> getClothesByName(String param){
        List<Cloth> listClothes = new ArrayList<Cloth>();
        for (Cloth cloth: clothes){
            if(cloth.getName().equalsIgnoreCase(param) || cloth.getName().contains(param))
                listClothes.add(cloth);
        }
        return listClothes;
    }
}
