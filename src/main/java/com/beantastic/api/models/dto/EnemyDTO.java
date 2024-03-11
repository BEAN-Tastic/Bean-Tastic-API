package com.beantastic.api.models.dto;

import java.util.*;

import com.beantastic.api.models.entities.BeanClassStatistic;
import com.beantastic.api.models.entities.Enemy;
import com.beantastic.api.models.entities.EnemyAction;
import com.beantastic.api.models.entities.EnemyDifficultyStatistic;
import com.beantastic.api.models.entities.EnemyStatisticModifier;
import com.beantastic.api.models.entities.StatisticType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EnemyDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("difficulty")
    private String difficulty;

    @JsonProperty("difficultyStats")
    private List<Map<String, Integer>> difficultyStats;

    @JsonProperty("actions")
    private List<Map<String, Object>> actions;

    @JsonProperty("statisticModifiers")
    private List<Map<String, Integer>> statisticModifiers;

    public EnemyDTO(Enemy enemy) {

        List<Map<String, Integer>> difficultyStatsList = new ArrayList<>();
        for (EnemyDifficultyStatistic entry : enemy.getEnemyDifficulty().getEnemyDifficultyStatistics()) {
            StatisticType statType = entry.getStatisticType();
            int points = entry.getPoints();

            Map<String, Integer> statEntry = new HashMap<>();
            statEntry.put(statType.getName(), points);

            difficultyStatsList.add(statEntry);
        }

        List<Map<String, Object>> actionsList = new ArrayList<>();
        for (EnemyAction action : enemy.getEnemyActions()) {
            Map<String, Object> actionMap = new HashMap<>();
            actionMap.put("name", action.getName());
            actionMap.put("description", action.getDescription());
            actionMap.put("statisticType", action.getStatisticType().getName());
            actionMap.put("multiplier", action.getActionType().getMultiplier());
            actionsList.add(actionMap);
        }

        List<Map<String, Integer>> statisticModifiersList = new ArrayList<>();
        for (EnemyStatisticModifier entry : enemy.getEnemyStatisticModifiers()) {
            StatisticType statType = entry.getStatisticType();
            int points = entry.getPoints();

            Map<String, Integer> statEntry = new HashMap<>();
            statEntry.put(statType.getName(), points);

            statisticModifiersList.add(statEntry);
        }

        this.name = enemy.getName();
        this.description = enemy.getDescription();
        this.difficulty = enemy.getEnemyDifficulty().getName();
        this.difficultyStats = difficultyStatsList;
        this.statisticModifiers = statisticModifiersList;
        this.actions = actionsList;
    }
}
