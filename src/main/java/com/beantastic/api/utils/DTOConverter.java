package com.beantastic.api.utils;

import java.util.*;

import com.beantastic.api.models.dto.*;
import com.beantastic.api.models.entities.*;

public class DTOConverter {

    public static BeanClassDTO beanToBeanDTO(BeanClass beanClass) {

        List<Map<String, Integer>> statsList = new ArrayList<>();
        for (BeanClassStatistic entry : beanClass.getBeanClassStatistics()) {

            StatisticType statType = entry.getStatisticType();
            int points = entry.getPoints();

            Map<String, Integer> statEntry = new HashMap<>();
            statEntry.put(statType.getName(), points);

            statsList.add(statEntry);

        }

        BeanClassDTO beanClassDTO = new BeanClassDTO(beanClass.getName(), beanClass.getDescription(), statsList);
        return beanClassDTO;
    }

    public static ItemDTO itemToItemDTO(Item item) {

        List<Map<String, Integer>> statsList = new ArrayList<>();
        for (ItemStatistic entry : item.getItemStatistics()) {

            StatisticType statType = entry.getStatisticType();
            int points = entry.getPoints();

            Map<String, Integer> statEntry = new HashMap<>();
            statEntry.put(statType.getName(), points);

            statsList.add(statEntry);

        }

        ItemDTO itemDTO = new ItemDTO(item.getName(), item.getDescription(), item.getItemQuality().getName(),
                statsList);
        return itemDTO;
    }

    public static EnemyDTO enemyToEnemyDTO(Enemy enemy) {

        List<Map<String, Integer>> difficultyStatisticsList = new ArrayList<>();
        for (EnemyDifficultyStatistic entry : enemy.getEnemyDifficulty().getEnemyDifficultyStatistics()) {
            StatisticType statType = entry.getStatisticType();
            int points = entry.getPoints();

            Map<String, Integer> statEntry = new HashMap<>();
            statEntry.put(statType.getName(), points);

            difficultyStatisticsList.add(statEntry);
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
        EnemyDTO enemyDTO = new EnemyDTO(enemy.getName(), enemy.getDescription(), enemy.getEnemyDifficulty().getName(),
                difficultyStatisticsList, actionsList, statisticModifiersList);

        return enemyDTO;
    }

}
