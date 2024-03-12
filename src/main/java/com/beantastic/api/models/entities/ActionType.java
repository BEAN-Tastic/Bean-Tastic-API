package com.beantastic.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "actiontype")
public class ActionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actiontypeid")
    private int actionTypeId;

    private String description;

    private float multiplier;

}
