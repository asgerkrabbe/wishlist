package com.demo.wishlist.view;

import com.demo.wishlist.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Controller
public class FrontController {

    //method for testing purposes
    private User getTestUser() {
        Gift gift1 = new Gift("sokker", 50, "www.thissocks");
        Gift gift2 = new Gift("handsker", 50, "www.thissocks");
        WishList wl = new WishList(null, "Fødselsdag", 1, 22);
        User testUser = new User("email", "Ines", "pass", 1);
        wl.addGift(gift1);
        wl.addGift(gift2);
        testUser.addWishList(wl);
        return testUser;

    }

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @PostMapping("/login")
    public String login(WebRequest request) {
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        // delegate work + data to login controller
        User user = UserHandler.login(email, pwd);
        request.setAttribute("user", getTestUser(), WebRequest.SCOPE_SESSION);
        // Go to to personal page
        return "/userpage";
    }

    @PostMapping("/register")
    public String createUser(WebRequest request) {
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");
        User user = UserHandler.createUser(userName, email, pass1, pass2);
        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        return "/userpage";
        //return "redirect:/success";
    }


    @GetMapping("/userpage")
    public String userPage(WebRequest request) {
        User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
        List<WishList> wishLists = WishListHandler.getWishLists(user.getUserId());
        request.setAttribute("wishlists", getTestUser().getWishLists(), WebRequest.SCOPE_SESSION);
        return "userPage.html";
    }

}
