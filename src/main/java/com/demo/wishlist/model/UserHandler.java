package com.demo.wishlist.model;
import com.demo.wishlist.data.DataFacade;
import com.demo.wishlist.data.WishlistException;

// This class should have the functions and logic code that involve the user data.
public class UserHandler {
    DataFacade dataFacade;

    public UserHandler() {
        dataFacade = new DataFacade();
    }

    public User login(String email, String password) throws WishlistException {
        return dataFacade.login(email, password);
    }

    public User createUser(String userName, String email, String pass1, String pass2) throws WishlistException {
        // if passwords match, email is valid and username is not empty....
        if (!pass1.equals(pass2)) {   throw new WishlistException("Passwords do not match");        }
        if (userName.equals("")) {   throw new WishlistException("User name field can not be empty");        }
        if (!email.matches("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+")) {
            throw new WishlistException("Email input is not valid");        }
        User user = new User(email, userName, pass1);
        return dataFacade.createUser(user);
    }

    public String getUserName(String userId) throws WishlistException {
        return dataFacade.getUserName(userId);
    }
}


