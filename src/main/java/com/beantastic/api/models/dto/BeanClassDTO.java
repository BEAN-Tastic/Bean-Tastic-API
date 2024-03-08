package com.beantastic.api.models.dto;

import java.util.*;

import com.beantastic.api.models.entities.BeanClass;
import com.beantastic.api.models.entities.BeanClassStatistic;
import com.beantastic.api.models.entities.StatisticType;

public class BeanClassDTO {
    private String name;

    private String description;

    private List<Map<String, Integer>> beanClassStatistics;

    public BeanClassDTO(String name, String description, List<Map<String, Integer>> beanClassStatistics) {
        this.name = name;
        this.description = description;
        this.beanClassStatistics = beanClassStatistics;
    }

    public BeanClassDTO(BeanClass beanClass) {
        List<Map<String, Integer>> statsList = new ArrayList<>();
        for (BeanClassStatistic entry : beanClass.getBeanClassStatistics()) {

            StatisticType statType = entry.getStatisticType();
            int points = entry.getPoints();

            Map<String, Integer> statEntry = new HashMap<>();
            statEntry.put(statType.getName(), points);

            statsList.add(statEntry);

        }

        this.name = beanClass.getName();
        this.description = beanClass.getDescription();
        this.beanClassStatistics = statsList;
    }

}
