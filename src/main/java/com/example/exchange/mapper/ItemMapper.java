package com.example.exchange.mapper;

import com.example.exchange.entity.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemMapper {

    @Insert("insert into item values (0,#{name},#{price},#{image},#{create_user},#{description})")
    public void addItem(Item item);
    @Update("update item set name=#{name},price=#{price},image=#{image},update_time=#{update_user},description=#{description} where id=#{id}")
    public void updateItem(Item item);
    @Select("select * from item where description like %#{description}%")
    public List<Item> getItem(String description);
    @Select("select * from item where id=#{id}")
    public Item getItemById(Long id);
    @Select("select * from item")
    public List<Item> getAllItem();

    @Delete("delete from item where id=#{id}")
    public void deleteItem(Item item);
}
