package com.SampleSpringProject1.project1.service;

import com.SampleSpringProject1.project1.entity.ItemTable;
import com.SampleSpringProject1.project1.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    public String saveItem(ItemTable itemTable)
    {
        itemRepo.save(itemTable);
        return "Single item is saved successfully";
    }
    public String saveItems(List<ItemTable> itemTables)
    {
        itemRepo.saveAll(itemTables);
        return "Multiple items are saved successfully";
    }
    public List<ItemTable> getAllItems()
    {
        return itemRepo.findAll();
    }
    public ItemTable getItemById(Integer id)
    {
        return itemRepo.findById(id).orElse(null);
    }
//    public ItemTable getItemByName(String item_name)
//    {
//        return itemRepo.findByName(item_name);
//    }
    public String deleteItem(Integer id)
    {
         itemRepo.deleteById(id);
        return "Item "+id + " has been deleted";
    }
    public ItemTable updateItem(ItemTable itemTable)
    {
        ItemTable existingItem=itemRepo.findById(itemTable.getItem_id()).orElse(null);
        existingItem.setItem_name(itemTable.getItem_name());
        existingItem.setProduct_type(itemTable.getProduct_type());
        existingItem.setQuantity(itemTable.getQuantity());
        return itemRepo.save(existingItem);
    }

}
