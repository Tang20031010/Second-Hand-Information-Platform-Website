package com.example.exchange.service;

import com.example.exchange.entity.Item;
import com.example.exchange.entity.User;

import java.util.List;
import java.util.Locale;

public interface ItemService {
    void addItem(Item item);
    void updateItem(Item item);
    List<Item> getItem(String description);
    Item getItemById(Long id);
    List<Item> getAllItem();

}
