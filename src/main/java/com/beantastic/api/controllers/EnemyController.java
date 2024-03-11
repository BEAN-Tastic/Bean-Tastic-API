package com.beantastic.api.controllers;

import com.beantastic.api.dao.EnemyRepository;
import com.beantastic.api.models.dto.EnemyDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnemyController {

    private final EnemyRepository enemyRepository;

    public EnemyController(EnemyRepository enemyRepository) {
        this.enemyRepository = enemyRepository;
    }

    @GetMapping(path = "/enemies")
    public ResponseEntity<?> getEnemies() {

        try {
            List<EnemyDTO> enemyDTOList = StreamSupport.stream(enemyRepository.findAll().spliterator(), false)
                    .map(EnemyDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(enemyDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());

        }
    }
}
