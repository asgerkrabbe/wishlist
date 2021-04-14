package com.demo.wishlist.data;

import com.demo.wishlist.model.*;

import java.sql.*;

public class DataAccess {
    UserMapper userMapper = new UserMapper();
    WishListMapper listMapper;

    public User login(String email, String password) throws LoginSampleException {
        return userMapper.login(email, password);
    }

    public User createUser(User user) throws LoginSampleException{
        return userMapper.createUser(user);
    }


}