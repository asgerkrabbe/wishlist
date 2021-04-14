package com.demo.wishlist.model;

public class Gift {

    private String giftName;
    private String description;
    private double price;
    private String url;


    public Gift(String giftName, double price, String url, String description) {
        this.giftName = giftName;
        this.price = price;
        this.url = url;
        this.description = description;
    }


    public String getGiftName() {
        return giftName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }
}
