package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
public class ActionType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int actionTypeId;

    private String description;

    private float multiplier;

}
