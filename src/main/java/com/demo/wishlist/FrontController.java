package com.demo.wishlist;
import com.demo.wishlist.model.User;
import com.demo.wishlist.model.UserHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class FrontController {

    @GetMapping ("/")
    public String index(){
        return "index.html";
    }

    @PostMapping("/login")
    public String login(WebRequest request){
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        // delegate work + data to login controller
        User user = UserHandler.login(email, pwd);
        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        // Go to to personal page
        return "/userpage";
    }

    @PostMapping("/register")
    public String createUser(WebRequest request){
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");
        User user = UserHandler.createUser(userName,email,pass1,pass2);
        return "/userpage";
        //return "redirect:/success";
    }


    @GetMapping("/userpage")
    public String userPage(){
        return "userPage.html";
    }

}
