package com.beantastic.api.models.entities;
import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table
public class ItemStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int itemStatisticId;

    @ManyToOne
    private Item item;

    @JoinColumn
    @ManyToOne
    private StatisticType statisticType;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int points;
}
