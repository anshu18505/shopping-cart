package com.demo3.demo3.controller;

import com.demo3.demo3.dto.ItemDto;
import com.demo3.demo3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/putItem")
    public String putItem(@RequestBody ItemDto itemDto)
    {
        return itemService.saveItem(itemDto);
    }

    @PostMapping("/putItems")
     public String putItems(@RequestBody List<ItemDto> itemDtoList)
    {
        return itemService.saveItems(itemDtoList);
    }

    @GetMapping("/getItems")
    public List<ItemDto> getItems()
    {
        return itemService.getAllItems();
    }

}
