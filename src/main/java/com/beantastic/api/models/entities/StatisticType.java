package com.beantastic.api.models.entities;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "statistictype")
public class StatisticType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statistictypeid")
    private int statistictypeid;

    private String name;

    private String description;

}