package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
public class EnemyDifficultyStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enemyDifficultyStatisticId;

    @ManyToOne
    private StatisticType statisticType;

    private int points;

}
