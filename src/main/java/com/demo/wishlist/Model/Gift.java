package com.demo.wishlist.Model;

public class Gift {

    private String giftName;
    private String description;
    private double price;
    private String url;


    public Gift(String giftName, String description, double price, String url) {
        this.giftName = giftName;
        this.description = description;
        this.price = price;
        this.url = url;
    }
}
