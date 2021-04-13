package com.demo.wishlist;

import com.demo.wishlist.data.DBManager;
import com.demo.wishlist.data.LoginSampleException;
import com.demo.wishlist.data.UserMapper;
import com.demo.wishlist.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WishlistApplication {

    public static void main(String[] args) throws LoginSampleException {
        SpringApplication.run(WishlistApplication.class, args);

        UserMapper userMapper = new UserMapper();

       // User user1 = new User("qwe@mail.com","qwe","1234",10);

       // userMapper.createUser(user1);*/

        userMapper.login("mail@mail.com", "1234");


    }
}