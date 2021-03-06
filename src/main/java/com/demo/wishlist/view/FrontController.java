package com.demo.wishlist.view;

import com.demo.wishlist.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import com.demo.wishlist.data.WishlistException;

import java.util.List;

@Controller
public class FrontController {

    UserHandler userHandler = new UserHandler();
    WishListHandler wishListHandler = new WishListHandler();

    /*
    //method for testing purposes
    private User getTestUser() {
        Gift gift1 = new Gift("sokker", 50, "www.thissocks", "desc");
        Gift gift2 = new Gift("handsker", 50, "www.thissocks", "desc");
        ArrayList<Gift> wl = new ArrayList<Gift>();
        User testUser = new User("email", "Ines", "pass");
        wl.add(gift1);
        wl.add(gift2);
        testUser.addWishList(wl);
        return testUser;
    }*/

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @PostMapping("/login")
    public String login(WebRequest request) throws WishlistException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        User user = userHandler.login(email, pwd);
        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        // Go to to personal page
        return "redirect:userdash";
    }

    @PostMapping("/register")
    public String createUser(WebRequest request) throws WishlistException {
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");
        User user = userHandler.createUser(userName, email, pass1, pass2);
        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        return "redirect:userdash";
    }


    @GetMapping("/userdash")
    public String userPage(WebRequest request) throws WishlistException {
        User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
        List<Gift> wishList = wishListHandler.getList(user.getUserId());
        if (wishList.size() != 0) {
            request.setAttribute("list", wishList, WebRequest.SCOPE_SESSION);
        }
        return "/userPage.html";
    }

    @PostMapping("/addgift")
    public String addGift(WebRequest request) throws WishlistException {
        User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
        int userId = user.getUserId();
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        String price = request.getParameter("price");
        String url = request.getParameter("url");
        wishListHandler.addGift(userId, name, desc, price, url);
        return "redirect:/userdash";
    }

    @ExceptionHandler(Exception.class)
    public String anotherError(Model model, Exception exception) {
        model.addAttribute("message", exception.getMessage());
        return "exceptionPage.html";
    }

    @GetMapping("/sharedList")
    public String shareList(@RequestParam("userid") String userId, WebRequest request) throws WishlistException {
        request.setAttribute("userid", userId,WebRequest.SCOPE_SESSION);
        String name = userHandler.getUserName(userId);
        List<Gift> wishList = wishListHandler.getList(Integer.parseInt(userId));
        request.setAttribute("list", wishList, WebRequest.SCOPE_SESSION);
        request.setAttribute("name", name, WebRequest.SCOPE_SESSION);
        return "wishlist.html";
    }

    @PostMapping("/get-link")
    public String generateLink(WebRequest request){
        User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
        int userId = user.getUserId();
        request.setAttribute("link", ("/sharedList?userid=" + userId), WebRequest.SCOPE_SESSION);
        return "userPage.html";
    }

    @PostMapping("/reserveGift")
    public String reserveGift(WebRequest request) throws WishlistException {
        String giftId = request.getParameter("gift-id");
        wishListHandler.reserveGift(giftId);
        String userId = (String) request.getAttribute("userid", WebRequest.SCOPE_SESSION);
        return "redirect:/sharedList2?userid=" + userId;
    }

    @GetMapping("/sharedList2")
    public String shareList2(@RequestParam("userid") String userId, WebRequest request) throws WishlistException {
        request.setAttribute("userid", userId,WebRequest.SCOPE_SESSION);
        String name = userHandler.getUserName(userId);
        List<Gift> wishList = wishListHandler.getList(Integer.parseInt(userId));
        request.setAttribute("list", wishList, WebRequest.SCOPE_SESSION);
        request.setAttribute("name", name, WebRequest.SCOPE_SESSION);
        return "success.html";
    }



}