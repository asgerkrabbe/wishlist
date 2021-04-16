package com.demo.wishlist.model;

public class Gift {

    private String giftName;
    private String description;
    private double price;
    private String url;
    private int userId;
    private int giftId;
    public boolean isReserved;


    public Gift(String giftName, double price, String url, String description, int userId) {
        this.giftName = giftName;
        this.price = price;
        this.url = url;
        this.description = description;
        this.userId = userId;
        isReserved = false;
        this.giftId = -1;
    }

    public void setUserId(int id){
        this.userId = id;
    }

    public void setReserved(){
        this.isReserved = true;
    }


    public void setGiftId(int id){
        giftId = id;
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

    public int getGiftId(){ return giftId; }

}
