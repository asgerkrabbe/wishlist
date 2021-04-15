package com.demo.wishlist.data;


import com.demo.wishlist.model.Gift;

import java.util.ArrayList;
import java.sql.*;

//class that will map the wish lists in the DB to the model wish lists.
public class WishListMapper {

    public ArrayList<Gift> getList(int user_id) throws WishlistException {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT name, price, url, description FROM gift WHERE user_id =?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();

            ArrayList<Gift> list = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String url = rs.getString("url");
                String description = rs.getString("description");
                Gift gift = new Gift(name, price, url, description, user_id);
                list.add(gift);
            }
            return list;
        } catch (SQLException ex) {
            throw new WishlistException(ex.getMessage());
        }
    }

    public void addGift(Gift gift) throws WishlistException {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO gift (name, price, url, description, user_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, gift.getGiftName());
            ps.setDouble(2, gift.getPrice());
            ps.setString(3, gift.getUrl());
            ps.setString(4, gift.getDescription());
            ps.setInt(5, gift.getUserId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new WishlistException(ex.getMessage());
        }
    }
}
