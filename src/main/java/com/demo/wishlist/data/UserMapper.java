package com.demo.wishlist.data;

import com.demo.wishlist.model.User;

import java.sql.*;

//Class in charge of mapping user data to DB
public class UserMapper {

    public String getUserName(String userId) throws WishlistException {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT username FROM user_data WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String userName = rs.getString("username");
            return userName;

        } catch (SQLException ex) {
            throw new WishlistException(ex.getMessage());
        }
    }


    /**
     * The method uses the user parameter in the SQL statement to create a new user.
     *
     * @param user
     * @throws WishlistException
     */

    public User createUser(User user) throws WishlistException {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO user_data (user_password, email, username) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUserName());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setUserId(id);
            return user;
        } catch (SQLException ex) {
            throw new WishlistException(ex.getMessage());
        }
    }

    /**
     * Compares parameter email and password via SQL statement.
     * If a match has been found, the if statement
     * will return af user with email, username, password and ID for session use
     *
     * @param email
     * @param password
     * @return
     * @throws WishlistException Custom made exception method. Without it, the "else" statement
     *                              would not be possible.
     */
    public User login(String email, String password) throws WishlistException {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT username, user_id FROM user_data "
                    + "WHERE email=? AND user_password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                int id = rs.getInt("user_id");
                User user = new User(email, username, password);
                user.setUserId(id);
                return user;
            } else {
                throw new WishlistException("Could not validate user");
            }
        } catch (SQLException ex) {
            throw new WishlistException(ex.getMessage());
        }
    }
}