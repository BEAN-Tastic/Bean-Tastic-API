package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
public class EnemyDifficultyStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int enemyDifficultyStatisticId;

    @ManyToOne
    private StatisticType statisticType;

    private int enemyDifficultyId;

}
