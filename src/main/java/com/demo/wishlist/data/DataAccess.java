package com.demo.wishlist.data;

import com.demo.wishlist.model.*;

import java.util.ArrayList;

public class DataAccess {
    UserMapper userMapper = new UserMapper();
    WishListMapper listMapper = new WishListMapper();

    public User login(String email, String password) throws LoginSampleException {
        return userMapper.login(email, password);
    }

    public User createUser(User user) throws LoginSampleException{
        return userMapper.createUser(user);
    }

    public ArrayList<Gift> getList(int userId) throws LoginSampleException {
        return listMapper.getList(userId);
    }
}