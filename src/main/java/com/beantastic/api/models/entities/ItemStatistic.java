package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class ItemStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemStatisticId;

    @ManyToOne
    private StatisticType statisticType;

    private String name;

    private String description;

    private int points;
}
