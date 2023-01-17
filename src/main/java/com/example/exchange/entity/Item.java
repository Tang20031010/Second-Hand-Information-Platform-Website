package com.example.exchange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    private Long id;
    private String name;
    private int price;
    private String image;
    private Long create_user;
    private String description;
}
