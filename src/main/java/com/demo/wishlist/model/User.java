package com.demo.wishlist.model;

import java.util.ArrayList;

public class User {

    private String email;
    private String userName;
    private String password;
    private int userId;
    private ArrayList<WishList> wishLists;

    public User(){};

    public User(String email, String userName, String password, int userId) {
        this.email = email;
        this.userName = userName;
        this.userId = userId;
        this.wishLists = new ArrayList<>();
    }

    public User(String email, String userName, String password, int userId, ArrayList<WishList> wishLists) {
        this.email = email;
        this.userName = userName;
        this.userId = userId;
        this.wishLists = wishLists;
    }
    public void addWishList(WishList wl){
        wishLists.add(wl);
    }

    public String getUserName(){
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    public ArrayList<WishList> getWishLists() {
        return wishLists;
    }
}
