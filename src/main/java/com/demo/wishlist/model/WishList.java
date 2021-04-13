package com.demo.wishlist.model;

import java.util.ArrayList;

public class WishList {

    private ArrayList<Gift> wishList;
    private String name;
    private int user_id;
    private int wishList_id;


    public WishList(){
        wishList = new ArrayList<Gift>();
    }
    public void addGift(Gift gift){
        wishList.add(gift);
    }


    public WishList(ArrayList<Gift> wishList, String name, int user_id, int wishList_id) {
        if (wishList == null)
            wishList = new ArrayList<>();
        this.wishList = wishList;
        this.name = name;
        this.user_id = user_id;
        this.wishList_id = wishList_id;
    }

    public String getName() {
        return name;
    }
}
