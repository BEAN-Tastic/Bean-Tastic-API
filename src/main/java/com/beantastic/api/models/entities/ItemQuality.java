package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class ItemQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemQualityId;

    private String name;
}
