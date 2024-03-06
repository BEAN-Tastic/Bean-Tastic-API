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
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int itemId;

    @JoinColumn
    @ManyToOne
    private ItemQuality itemQuality;

    @Column
    private String name;

    @Column
    private String description;
}
