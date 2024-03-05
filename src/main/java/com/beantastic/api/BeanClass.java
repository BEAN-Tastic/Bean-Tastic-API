package com.beantastic.api;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

@Entity
@Table(name = "BeanClass")
public class BeanClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BeanClassID")
    private int beanClassID;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Description")
    private String Description;

    @OneToMany(mappedBy = "beanClass", cascade = CascadeType.ALL)
    private List<BeanClassStatistics> statistics;

    public BeanClass(int beanClassID, String name, String description, List<BeanClassStatistics> statistics) {
        this.beanClassID = beanClassID;
        Name = name;
        Description = description;
        this.statistics = statistics;
    }

    public int getBeanClassID() {
        return beanClassID;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public List<BeanClassStatistics> getStatistics() {
        return statistics;
    }

}
