package com.demo.wishlist.data;

import com.demo.wishlist.model.*;

import java.util.ArrayList;

public class DataFacade {
    UserMapper userMapper = new UserMapper();
    WishListMapper listMapper = new WishListMapper();

    public User login(String email, String password) throws WishlistException {
        return userMapper.login(email, password);
    }

    public User createUser(User user) throws WishlistException {
        return userMapper.createUser(user);
    }

    public ArrayList<Gift> getList(int userId) throws WishlistException {
        return listMapper.getList(userId);
    }

    public void addGift(Gift gift) throws WishlistException {
        listMapper.addGift(gift);
    }

    public String getUserName(String userId) throws WishlistException {
       return userMapper.getUserName(userId);
    }
}