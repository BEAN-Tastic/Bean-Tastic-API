package com.beantastic.api.models.entities;

import lombok.*;
import java.util.*;
import jakarta.persistence.*;

@Data
@Entity
@Table
public class BeanClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int beanClassId;

    private String name;

    private String description;

    @OneToMany
    private List<BeanClassStatistic> beanClassStatistics;
}
