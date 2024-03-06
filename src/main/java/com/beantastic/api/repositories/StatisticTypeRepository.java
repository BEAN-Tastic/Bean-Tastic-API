package com.beantastic.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.beantastic.api.models.entities.StatisticType;

public interface StatisticTypeRepository extends CrudRepository<StatisticType, Integer> {
}