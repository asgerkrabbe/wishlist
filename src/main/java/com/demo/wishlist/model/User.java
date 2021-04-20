package com.demo.wishlist.model;

import java.util.ArrayList;

public class User {

    private String email;
    private String userName;
    private String password;
    private int userId;
    private ArrayList<Gift> myList;

    public User() { }

    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        myList = new ArrayList<Gift>();
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() { return userId;    }

    public void setUserId ( int userId){
        this.userId = userId;
    }

    }


