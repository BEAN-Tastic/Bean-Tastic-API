package com.beantastic.api.controllers;

import com.beantastic.api.dao.EnemyRepository;
import com.beantastic.api.models.dto.EnemyDTO;
import com.beantastic.api.utils.DTOConverter;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity getEnemies() {

        try {
            List<EnemyDTO> enemyDTOList = enemyRepository.findAll().stream()
                    .map(enemy -> DTOConverter.enemyToEnemyDTO(enemy))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(enemyDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());

        }
    }
}
