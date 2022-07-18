package com.SampleSpringProject1.project1.controller;

import com.SampleSpringProject1.project1.entity.ItemTable;
import com.SampleSpringProject1.project1.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/addItem")
    public String addItem(@RequestBody  ItemTable itemTable)
    {
        return itemService.saveItem(itemTable);
    }

    @PostMapping("/addItems")
    public String addItems(@RequestBody List<ItemTable> itemTables)
    {
        return itemService.saveItems(itemTables);
    }

    @GetMapping("/getItems")
    public List<ItemTable> findAllItems()
    {
        return itemService.getAllItems();
    }

    @GetMapping("/getItemById/{id}")
    public ItemTable findItemById(@PathVariable Integer id)
    {
        return itemService.getItemById(id);
    }

//    @GetMapping("/getItemByName/{item_name}")
//    public ItemTable findItemById(@PathVariable String item_name)
//    {
//        return itemService.getItemByName(item_name);
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable Integer id)
    {
        return itemService.deleteItem(id);
    }

    @PutMapping("/update")
    public ItemTable updateItem(@RequestBody ItemTable itemTable)
    {
        return itemService.updateItem(itemTable);
    }
}
