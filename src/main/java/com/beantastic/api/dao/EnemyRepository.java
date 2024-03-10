package com.beantastic.api.dao;

import com.beantastic.api.models.entities.Enemy;
import org.springframework.data.repository.CrudRepository;

public interface EnemyRepository extends CrudRepository<Enemy, Integer> {
}