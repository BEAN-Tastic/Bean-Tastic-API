package com.beantastic.api.dao;

import com.beantastic.api.models.entities.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
