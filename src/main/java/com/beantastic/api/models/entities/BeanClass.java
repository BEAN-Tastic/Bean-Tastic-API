package com.beantastic.api.models.entities;

import lombok.*;
import java.util.*;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "beanclass")
public class BeanClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beanclassid")
    private int beanClassId;

    private String name;

    private String description;

    @OneToMany
    @JoinColumn(name = "beanclassid")
    private List<BeanClassStatistic> beanClassStatistics;
}
