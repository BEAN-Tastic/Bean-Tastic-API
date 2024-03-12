package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "itemstatistic")
public class ItemStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemstatisticid")
    private int itemStatisticId;

    @ManyToOne
    @JoinColumn(name = "statistictypeid")
    private StatisticType statisticType;

    private String name;

    private String description;

    private int points;
}
