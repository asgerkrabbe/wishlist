package com.demo.wishlist.model;

import com.demo.wishlist.data.DataFacade;
import com.demo.wishlist.data.LoginSampleException;

import java.util.ArrayList;

public class WishListHandler {
    DataFacade dataFacade = new DataFacade();

    public ArrayList<Gift> getList(int userId) throws LoginSampleException {
        //This should forward the user ID to the database and retrieve the users lists.
        return dataFacade.getList(userId);
    }
}