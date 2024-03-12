package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "enemystatisticmodifier")
public class EnemyStatisticModifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enemystatisticmodifierid")
    private int enemyStatisticModifierId;

    @ManyToOne
    @JoinColumn(name = "statisticid")
    private StatisticType statisticType;

    private int points;

}
