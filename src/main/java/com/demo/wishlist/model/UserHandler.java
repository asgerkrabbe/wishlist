package com.demo.wishlist.model;

import com.demo.wishlist.data.DataFacade;
import com.demo.wishlist.data.LoginSampleException;

// This class should have the functions and logic code that involve the user data.
public class UserHandler {
    DataFacade dataFacade;

    public UserHandler (){
        dataFacade = new DataFacade();
    }

    //UsersRepo usersRepository;
   public User login(String email, String password) throws LoginSampleException {
       return dataFacade.login(email, password);
   }

    public User createUser(String userName, String email, String pass1, String pass2) throws LoginSampleException {
        // if passwords match, email is valid and username is not empty....
        User user = new User (email, userName, pass1);
        return dataFacade.createUser(user);
        // forward the user data to the database and get user_Id, then
        //create a new user object and return it to the UI controller
        //UsersRepo.createUser(userName, email, pass1, pass2);
        //then return user
    }

   }


   //
//
//        return facade.login(email, password);
//    }
//
//    public User createUser(String email, String password) throws LoginSampleException {
//        // By default, new users are customers
//        User user = new User(email, password, "customer");
//        facade.createUser(user);
//        return user;
//    }


