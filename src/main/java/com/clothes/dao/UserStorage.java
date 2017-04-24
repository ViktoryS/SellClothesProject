package com.clothes.dao;

import com.clothes.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    public static ArrayList<User> users = new ArrayList<User>();
    
    private UserStorage(){}


    public static List<User> getAllUsers() {
        return users;
    }

    public static User getUser(long id) {
        for (User User: users)
            if(User.getId() == id)
                return User;
        return null;
    }

    public static User getUser(String name) {
        for (User User: users)
            if(name.equals(User.getName()))
                return User;
        return null;
    }

    public static boolean addUser(User User) {
        return users.add(User);
    }

    public static boolean isEmpty() {
        return users.isEmpty();
    }

    public static boolean removeUser(User User){
        return users.remove(User);
    }

    public static List<User> getUsersByName(String param){
        List<User> listUsers = new ArrayList<User>();
        for (User User: users){
            if(User.getName().equalsIgnoreCase(param) || User.getName().contains(param))
                listUsers.add(User);
        }
        return listUsers;
    }
}
