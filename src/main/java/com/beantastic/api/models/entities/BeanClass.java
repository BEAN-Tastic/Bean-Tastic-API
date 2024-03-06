package com.beantastic.api.models.entities;

import java.util.*;
import lombok.*;
import jakarta.persistence.*;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class BeanClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int beanClassID;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "beanClass", fetch = FetchType.EAGER)
    @Column
    private Set<BeanClassStatistic> beanClassStatistics;

    public BeanClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
