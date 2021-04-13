package com.demo.wishlist.model;

public class UserHandler {

    //UsersRepo usersRepository;
    // This class should have the logic code in the


   public static User login(String email, String password) {
       return new User();
       //if
       //UsersRepo.login(email, password);
   }

    public static User createUser(String userName, String email, String pass1, String pass2) {
        return new User();
        // if passwords match, email is valid and username is not empty....
        //UsersRepo.createUser(userName, email, pass1, pass2);
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


