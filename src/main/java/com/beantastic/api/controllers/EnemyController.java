package com.beantastic.api.controllers;

import com.beantastic.api.dao.EnemyRepository;
import com.beantastic.api.models.entities.Enemy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnemyController {

    private final EnemyRepository enemyRepository;

    public EnemyController(EnemyRepository enemyRepository) {
        this.enemyRepository = enemyRepository;
    }

    @GetMapping(path = "/enemies")
    public Iterable<Enemy> getEnemies() {
        return enemyRepository.findAll();
    }
}
