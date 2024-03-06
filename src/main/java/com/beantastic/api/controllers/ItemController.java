package com.beantastic.api.controllers;

import com.beantastic.api.dao.ItemRepository;
import com.beantastic.api.models.entities.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping(path = "/items")
    public Iterable<Item> getItems() {
        return itemRepository.findAll();
    }
}
