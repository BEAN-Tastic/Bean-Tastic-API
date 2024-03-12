package com.beantastic.api.models.entities;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "enemy")
public class Enemy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enemyid")
    private int enemyId;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "enemydifficultyid")
    private EnemyDifficulty enemyDifficulty;

    @OneToMany
    @JoinColumn(name = "enemyactionid")
    private List<EnemyAction> enemyActions;

    @OneToMany
    @JoinColumn(name = "enemystatisticmodifierid")
    private List<EnemyStatisticModifier> enemyStatisticModifiers;
}
