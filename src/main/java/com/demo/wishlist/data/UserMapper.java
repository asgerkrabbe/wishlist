package com.demo.wishlist.data;

import com.demo.wishlist.model.User;

import java.sql.*;

//Class in charge of mapping user data to DB
public class UserMapper {

    /**
     * The method uses the user parameter in the SQL statement to create a new user.
     * @param user
     * @throws LoginSampleException
     */

    public void createUser(User user) throws LoginSampleException {
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
        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    /**
     * Compares parameter email and password via SQL statement.
     * If a match has been found, the if statement
     * will return af user with email, username, password and ID for session use
     * @param email
     * @param password
     * @return
     * @throws LoginSampleException Custom made exception method. Without it, the "else" statement
     *                              would not be possible.
     */
    public User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT email, username, user_password, id FROM user_data "
                        + "WHERE email=? AND user_password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                int id = rs.getInt("id");
                User user = new User(email, username, password, id);
                user.setUserId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}