package com.clothes.dao;

import com.clothes.model.User;
import com.clothes.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Logger logger = Logger.getLogger(UserDAO.class);

    private UserDAO(){}

    public static List<User> getAllUsers(){
        Session session = null;
        List<User> users = new ArrayList<User>();
        try {
            session = sessionFactory.openSession();
            logger.debug("Open session..");
            session.beginTransaction();
            logger.debug("Begin transaction");
            users = (List<User>) session.createQuery("FROM User").list();
            logger.debug("list of users was initialised");
            session.getTransaction().commit();
        }catch (Exception e){
            logger.error("Error of getting users from DB! " + e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return users;
    }

    public static User getUser(long id) {
        for (User User: getAllUsers())
            if(User.getId() == id)
                return User;
        return null;
    }

    public static User getUser(String name) {
        for (User User: getAllUsers())
            if(name.equals(User.getName()))
                return User;
        return null;
    }

    public static void addUser(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            logger.debug("Open session..");
            session.beginTransaction();
            logger.debug("Begin transaction");
            session.persist(user);
            logger.debug("New user was saved!");
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
        return getAllUsers().isEmpty();
    }

    public static boolean removeUser(User User){
        return getAllUsers().remove(User);
    }

    public static List<User> getUsersByName(String param){
        List<User> listUsers = new ArrayList<User>();
        for (User user: getAllUsers()){
            if(user.getName().equalsIgnoreCase(param) || user.getName().contains(param))
                listUsers.add(user);
        }
        return listUsers;
    }
}
