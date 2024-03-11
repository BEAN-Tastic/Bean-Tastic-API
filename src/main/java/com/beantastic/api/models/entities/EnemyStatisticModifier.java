package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
public class EnemyStatisticModifier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int enemyStatisticModifierId;

    @ManyToOne
    private StatisticType statisticType;

    private int points;

}