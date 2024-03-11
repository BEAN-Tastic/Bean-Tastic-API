package com.beantastic.api.dao;

import com.beantastic.api.models.entities.Enemy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnemyRepository extends JpaRepository<Enemy, Integer> {
}