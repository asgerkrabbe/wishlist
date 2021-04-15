package com.demo.wishlist.data;


import com.demo.wishlist.model.Gift;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.sql.*;

//class that will map the wish lists in the DB to the model wish lists.
public class WishListMapper {

    public ArrayList<Gift> getList(int user_id) throws LoginSampleException {
        try {
            Connection con = DBManager.getConnection();
            Statement statement = con.createStatement();
            String SQL = "SELECT name, price, url, description FROM gift WHERE user_id =" + user_id;
            ResultSet rs = statement.executeQuery(SQL);
            ArrayList<Gift> list = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String url = rs.getString("url");
                String description = rs.getString("description");
                Gift gift = new Gift(name, price, url, description);
                gift.setUserId(user_id);
                list.add(gift);
            }
            return list;
        }
        catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }

//    public ArrayList<Gift> getList(int user_id) throws LoginSampleException {
//        try {
//            Connection con = DBManager.getConnection();
//            String SQL = "SELECT name, price, url, description FROM gift WHERE user_id =" + user_id;
//
//            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
//            ps.setInt(1, user_id);
//
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(SQL);
//
//
//            ArrayList<Gift> list = new ArrayList<>();
//
//            while (rs.next()) {
//                String name = rs.getString("name");
//                int price = rs.getInt("price");
//                String url = rs.getString("url");
//                String description = rs.getString("description");
//                Gift gift = new Gift(name, price, url, description);
//                gift.setUserId(user_id);
//                list.add(gift);
//            }
//            return list;
//        }
//        catch (SQLException ex) {
//            throw new LoginSampleException(ex.getMessage());
//        }
//    }
}
