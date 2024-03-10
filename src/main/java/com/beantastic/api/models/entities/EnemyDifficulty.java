package com.beantastic.api.models.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
public class EnemyDifficulty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int enemyDifficultyId;

    private String name;

    private String description;

    @OneToMany
    List<EnemyDifficultyStatistic> enemyDifficultyStatistics;
}
