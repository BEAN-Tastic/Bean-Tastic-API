package com.beantastic.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beantastic.api.models.entities.BeanClass;

public interface BeanClassRepository extends JpaRepository<BeanClass, Integer> {
}
