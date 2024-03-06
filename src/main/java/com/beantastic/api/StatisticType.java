package com.beantastic.api;

import java.util.*;
import lombok.*;
import jakarta.persistence.*;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class StatisticType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statisticTypeID;

    private String name;

    private String description;

    @OneToMany(mappedBy = "statisticType")
    Set<BeanClassStatistics> beanClassStatistics;

    public StatisticType(String name, String description) {
        this.name = name;
        this.description = description;
    }

}