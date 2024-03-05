package com.beantastic.api;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "BeanClassStatistics")
public class BeanClassStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BeanClassStatisticsID")
    private int beanClassStatisticsID;

    @ManyToOne
    @JoinColumn(name = "BeanClassID", referencedColumnName = "BeanClassID")
    private BeanClass beanClass;

    @ManyToOne
    @JoinColumn(name = "StatisticTypeID", referencedColumnName = "StatisticTypeID")
    private StatisticsType statisticType;

    @Column(name = "Power")
    private int power;

    public BeanClassStatistics(int beanClassStatisticsID, BeanClass beanClass, StatisticsType statisticType,
            int power) {
        this.beanClassStatisticsID = beanClassStatisticsID;
        this.beanClass = beanClass;
        this.statisticType = statisticType;
        this.power = power;
    }

    public int getBeanClassStatisticsID() {
        return beanClassStatisticsID;
    }

    public BeanClass getBeanClass() {
        return beanClass;
    }

    public StatisticsType getStatisticType() {
        return statisticType;
    }

    public int getPower() {
        return power;
    }

}