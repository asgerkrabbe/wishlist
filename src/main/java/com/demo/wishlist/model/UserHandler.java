package com.demo.wishlist.model;

// This class should have the functions and logic code that involve the user data.
public class UserHandler {

    //UsersRepo usersRepository;
   public static User login(String email, String password) {
       return new User();
       //if
       //UsersRepo.login(email, password);
   }

    public static User createUser(String userName, String email, String pass1, String pass2) {
        // if passwords match, email is valid and username is not empty....
        // forward the user data to the database and get user_Id, then
        //create a new user object and return it to the UI controller
        //UsersRepo.createUser(userName, email, pass1, pass2);
        //then return user
        return new User();
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


