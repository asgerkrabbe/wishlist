package com.demo.wishlist.model;

public class Gift {

    private String giftName;
    private String description;
    private double price;
    private String url;
    private int userId;


    public Gift(String giftName, double price, String url, String description, int userId) {
        this.giftName = giftName;
        this.price = price;
        this.url = url;
        this.description = description;
        this.userId = userId;
    }

    public void setUserId(int id){
        this.userId = id;
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

    public int getUserId(){ return userId; }
}
