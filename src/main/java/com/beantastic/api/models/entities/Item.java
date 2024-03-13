package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemid")
    private int itemId;

    @ManyToOne
    @JoinColumn(name = "itemqualityid")
    private ItemQuality itemQuality;

    @OneToMany
    @JoinColumn(name = "itemid")
    private List<ItemStatistic> itemStatistics;

    private String name;

    private String description;
}
