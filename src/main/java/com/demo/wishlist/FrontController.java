package com.demo.wishlist;


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
        setSessionInfo(request, user);

        // Go to to page dependent on role
        return "userpages/" + user.getRole();
    }

}
