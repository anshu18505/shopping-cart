package com.demo3.demo3.service;

import com.demo3.demo3.dto.ItemDto;
import com.demo3.demo3.entity.Item;
import com.demo3.demo3.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    public String saveItem(ItemDto itemDto)
    {
        Item item=new Item(itemDto.getName(),itemDto.getType(),itemDto.getPrice(),itemDto.getQuantity());
        itemRepo.save(item);
        return "Item saved successfully";
    }
    public String saveItems(List<ItemDto> itemsDto)
    {
        List<Item> itemArrayList=new ArrayList<>();

        for(ItemDto itemDto : itemsDto)
        {
            Item item=new Item();
            item=new Item(itemDto.getName(),itemDto.getType(),itemDto.getPrice(),itemDto.getQuantity());
            itemArrayList.add(item);
            itemRepo.saveAll(itemArrayList);

        }
        return "Multiple Items saved";
    }

    public List<ItemDto> getAllItems()
    {
        List<Item> items=itemRepo.findAll();
        List<ItemDto> itemDtos=new ArrayList<>();
        for(Item item:items)
        {
            ItemDto itemDto=new ItemDto(item.getId(),item.getName(),item.getType(),item.getPrice(),item.getQuantity());
            itemDtos.add(itemDto);
        }
        return itemDtos;
    }

}
