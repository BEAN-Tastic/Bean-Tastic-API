package com.beantastic.api.models.entities;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table
public class ItemQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int itemQualityId;

    @Column
    private String name;
}
