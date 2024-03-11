package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
public class EnemyAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enemyActionId;

    @ManyToOne
    private StatisticType statisticType;

    @ManyToOne
    private ActionType actionType;

    private String name;

    private String description;

}
