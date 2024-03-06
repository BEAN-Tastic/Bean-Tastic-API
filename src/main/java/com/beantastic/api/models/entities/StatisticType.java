package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table
public class StatisticType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int statisticTypeId;

    @Column
    private String name;

    @Column
    private String description;
}
