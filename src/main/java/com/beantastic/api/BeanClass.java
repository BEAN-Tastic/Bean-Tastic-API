package com.beantastic.api;

import java.util.*;
import lombok.*;
import jakarta.persistence.*;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class BeanClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int beanClassID;

    private String name;

    private String description;

    @OneToMany(mappedBy = "beanClass")
    private Set<BeanClassStatistics> beanClassStatistics;

    public BeanClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
