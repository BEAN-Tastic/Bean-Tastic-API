package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "beanclassstatistic")
public class BeanClassStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beanclassstatisticid")
    private int beanClassStatisticsId;

    @ManyToOne
    @JoinColumn(name = "statistictypeid")
    private StatisticType statisticType;

    private int points;

}
