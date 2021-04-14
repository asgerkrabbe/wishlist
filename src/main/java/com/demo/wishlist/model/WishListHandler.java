package com.demo.wishlist.model;

import com.demo.wishlist.data.DBManager;
import com.demo.wishlist.data.DataAccess;
import com.demo.wishlist.data.LoginSampleException;

import java.sql.*;
import java.util.ArrayList;

public class WishListHandler {
    DataAccess dataAccess = new DataAccess();

    public ArrayList<Gift> getList(int userId) throws LoginSampleException {
        //This should forward the user ID to the database and retrieve the users lists.
        return dataAccess.getList(userId);
    }
}