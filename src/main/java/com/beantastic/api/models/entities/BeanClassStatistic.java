package com.beantastic.api.models.entities;

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
    @Column
    private int beanClassStatisticsID;

    @ManyToOne
    @JoinColumn
    private BeanClass beanClass;

    @ManyToOne
    @JoinColumn
    private StatisticType statisticType;

    private int points;

    public BeanClassStatistic(BeanClass beanClass, StatisticType statisticType, int points) {
        this.beanClass = beanClass;
        this.statisticType = statisticType;
        this.points = points;
    }

}
