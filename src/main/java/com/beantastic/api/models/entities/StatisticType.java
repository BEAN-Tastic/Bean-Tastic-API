package com.beantastic.api.models.entities;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table
public class StatisticType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statisticTypeId;

    private String name;

    private String description;

}