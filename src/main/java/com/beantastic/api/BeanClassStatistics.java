package com.beantastic.api;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class BeanClassStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int beanClassStatisticsID;

    @ManyToOne
    @JoinColumn(name = "beanClassID")
    private BeanClass beanClass;

    @ManyToOne
    @JoinColumn(name = "statisticTypeID")
    private StatisticType statisticType;

    private int power;

    public BeanClassStatistics(BeanClass beanClass, StatisticType statisticType, int power) {
        this.beanClass = beanClass;
        this.statisticType = statisticType;
        this.power = power;
    }

}
