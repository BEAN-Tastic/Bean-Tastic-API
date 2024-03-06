package com.beantastic.api.models.entities;

import lombok.*;
import jakarta.persistence.*;

@Data
@EqualsAndHashCode
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class StatisticType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int statisticTypeId;

    @Column
    private String name;

    @Column
    private String description;

    public StatisticType(String name, String description) {
        this.name = name;
        this.description = description;
    }

}