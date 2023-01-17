package com.example.exchange.service.Impl;

import com.example.exchange.entity.Item;
import com.example.exchange.mapper.ItemMapper;
import com.example.exchange.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public void addItem(Item item) {
        itemMapper.addItem(item);
    }

    @Override
    public void updateItem(Item item) {
        itemMapper.updateItem(item);
    }

    @Override
    public List<Item> getItem(String description) {
        return itemMapper.getItem(description);
    }

    @Override
    public Item getItemById(Long id) {
        return itemMapper.getItemById(id);
    }

    @Override
    public List<Item> getAllItem() {
        return itemMapper.getAllItem();
    }
}
