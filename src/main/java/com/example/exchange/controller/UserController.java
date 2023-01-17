package com.example.exchange.controller;

import com.example.exchange.entity.Item;
import com.example.exchange.entity.User;
import com.example.exchange.service.ItemService;
import com.example.exchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @GetMapping("/login")
    public String userLoginPage(HttpSession session){

        session.setAttribute("currUser",new User(0L,"zhang.1@osu.edu","junwei","1111"));
        return "signin";
    }

    @PostMapping("UserLogin")
    public String login(@RequestParam("email")String email,
                        @RequestParam("password")String password,
                        HttpSession session,
                        Model model){
        User user = userService.login(email,password);

        if(user != null){
            model.addAttribute("currUser",user);
            session.setAttribute("currUser",user);
            List<Item> allItems = itemService.getAllItem();
            session.setAttribute("allItems",allItems);
            return "listItem";
        }
        return "signin";
    }


}
