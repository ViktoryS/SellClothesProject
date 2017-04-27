package com.clothes.model;

public class UserBuilder {
    private User user;
    private static long userIds = 1;

    public UserBuilder(){
        this.user = new User();
        user.setId(userIds++);
    }

    public UserBuilder setName(String name){
        this.user.setName(name);
        return this;
    }

    public UserBuilder setLogin(String login){
        this.user.setLogin(login);
        return this;
    }

    public UserBuilder setPassword(String password){
        this.user.setPassword(password);
        return this;
    }

    public UserBuilder setEmail(String email){
        this.user.setEmail(email);
        return this;
    }

    public User buildUser(){
        return this.user;
    }

}
