package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "itemquality")
public class ItemQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemqualityid")
    private int itemQualityId;

    private String name;
}
