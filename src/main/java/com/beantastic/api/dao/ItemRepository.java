package com.beantastic.api.dao;

import com.beantastic.api.models.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> { }
