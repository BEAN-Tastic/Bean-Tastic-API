package com.beantastic.api.models.entities;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
public class Enemy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int enemyId;

    private String name;

    private String description;

    @ManyToOne
    private EnemyDifficulty enemyDifficulty;

    @OneToMany
    private List<EnemyAction> enemyActions;

    @ManyToMany
    private List<EnemyStatisticModifier> enemyStatisticModifiers;
}
