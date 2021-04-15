package com.demo.wishlist.model;

import com.demo.wishlist.data.DataFacade;
import com.demo.wishlist.data.WishlistException;

import java.util.ArrayList;

public class WishListHandler {
    DataFacade dataFacade = new DataFacade();

    public ArrayList<Gift> getList(int userId) throws WishlistException {
        //This should forward the user ID to the database and retrieve the users lists.
        return dataFacade.getList(userId);
    }

    public void addGift(int userId, String name, String desc, String price, String url ) throws WishlistException {
    if ( name.length() == 0)
    {throw new WishlistException("Name field can not be empty");}
    double doublePrice = Double.parseDouble(price);
    Gift gift = new Gift(name, doublePrice, url, desc, userId);
    dataFacade.addGift(gift);
}
}