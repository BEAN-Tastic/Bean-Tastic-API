package com.beantastic.api;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "StatisticsType")
public class StatisticsType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StatisticsTypeID")
    private int statisticsTypeID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description", length = 30)
    private String description;

    public StatisticsType(int statisticsTypeID, String name, String description) {
        this.statisticsTypeID = statisticsTypeID;
        this.name = name;
        this.description = description;
    }

    public int getStatisticsTypeID() {
        return statisticsTypeID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}