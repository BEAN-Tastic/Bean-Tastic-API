package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
public class BeanClassStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int beanClassStatisticsId;

    @ManyToOne
    private StatisticType statisticType;

    private int points;

}
