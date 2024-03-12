package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "enemyaction")
public class EnemyAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enemyactionid")
    private int enemyActionId;

    @ManyToOne
    @JoinColumn(name = "statistictypeid")
    private StatisticType statisticType;

    @ManyToOne
    @JoinColumn(name = "actiontypeid")
    private ActionType actionType;

    private String name;

    private String description;

}
