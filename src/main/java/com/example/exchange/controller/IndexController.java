package com.example.exchange.controller;

import com.example.exchange.entity.Item;
import com.example.exchange.entity.User;
import com.example.exchange.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sun.security.provider.MD5;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class IndexController {

    @Autowired
    private ItemService itemService;

    @GetMapping("post")
    public String toPost(){
        return "post";
    }

    @GetMapping("showItemDetail/{id}")
    public String showDetail(@PathVariable("id")Long id,
                             HttpSession session){
        Item item = itemService.getItemById(id);
        session.setAttribute("currItem",item);
        return "itemDetail";
    }
    @PostMapping("/UserPostItem")
    public String postItem(@RequestParam("name")String name,
                           @RequestParam("email")String email,
                           @RequestParam("price")int price,
                           @RequestParam("description")String description,
                           @RequestParam("file") MultipartFile file,
                           HttpSession session){

        String imageName = file.getName();
        User currUser = (User)session.getAttribute("currUser");

        Item postItem = new Item(0L, name, price, imageName, currUser.getId(), description);
        itemService.addItem(postItem);

        return "listItem";
    }



}
