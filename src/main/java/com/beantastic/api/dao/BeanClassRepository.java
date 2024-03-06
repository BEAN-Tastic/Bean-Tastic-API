package com.beantastic.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.beantastic.api.models.entities.BeanClass;

public interface BeanClassRepository extends CrudRepository<BeanClass, Integer> {
}
