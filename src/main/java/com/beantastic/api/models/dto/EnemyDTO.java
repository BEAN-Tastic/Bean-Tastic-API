package com.beantastic.api.models.dto;

import java.util.*;

import com.beantastic.api.models.entities.Enemy;
import com.beantastic.api.models.entities.EnemyAction;
import com.beantastic.api.models.entities.EnemyDifficultyStatistic;
import com.beantastic.api.models.entities.EnemyStatisticModifier;
import com.beantastic.api.models.entities.StatisticType;

import lombok.Data;

@Data
public class EnemyDTO {

    private String name;

    private String description;

    private String difficulty;

    private List<Map<String, Integer>> difficultyStats;

    private List<Map<String, Object>> actions;

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
