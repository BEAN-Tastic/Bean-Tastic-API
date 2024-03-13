package com.beantastic.api.models.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "enemydifficulty")
public class EnemyDifficulty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enemydifficultyid")
    private int enemyDifficultyId;

    private String name;

    private String description;

    @OneToMany
    @JoinColumn(name = "enemydifficultyid")
    List<EnemyDifficultyStatistic> enemyDifficultyStatistics;
}
