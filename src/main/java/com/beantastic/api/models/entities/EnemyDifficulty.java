package com.beantastic.api.models.entities;

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

}
