package com.beantastic.api.controllers;

import com.beantastic.api.dao.ItemRepository;
import com.beantastic.api.models.dto.ItemDTO;

import com.beantastic.api.utils.DTOConverter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping(path = "/items")
    public ResponseEntity getItems() {

        try {
            List<ItemDTO> itemDTOList = itemRepository.findAll().stream()
                    .map(item -> DTOConverter.itemToItemDTO(item))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(itemDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());

        }
    }
}
