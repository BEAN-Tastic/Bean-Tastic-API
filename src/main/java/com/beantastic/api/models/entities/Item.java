package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @ManyToOne
    private ItemQuality itemQuality;

    @OneToMany
    private List<ItemStatistic> itemStatistics;

    private String name;

    private String description;
}
