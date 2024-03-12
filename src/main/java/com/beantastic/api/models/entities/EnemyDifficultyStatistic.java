package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "enemydifficultystatistic")
public class EnemyDifficultyStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enemydifficultystatiticid")
    private int enemydifficultystatiticid;

    @ManyToOne
    @JoinColumn(name = "statistictypeid")
    private StatisticType statisticType;

    private int points;

}
