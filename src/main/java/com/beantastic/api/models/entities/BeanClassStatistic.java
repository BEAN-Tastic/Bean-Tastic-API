package com.beantastic.api.models.entities;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class BeanClassStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int beanClassStatisticsID;

    @ManyToOne
    @JoinColumn(name = "beanClassID")
    private BeanClass beanClass;

    @ManyToOne
    @JoinColumn(name = "statisticTypeID")
    private StatisticType statisticType;

    private int points;

    public BeanClassStatistic(BeanClass beanClass, StatisticType statisticType, int points) {
        this.beanClass = beanClass;
        this.statisticType = statisticType;
        this.points = points;
    }

}
