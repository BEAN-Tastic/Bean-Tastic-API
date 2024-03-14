package com.beantastic.api.utils;

import java.util.*;
import java.util.stream.*;

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

        List<String> actionsList = new ArrayList<>();
        for (EnemyAction action : enemy.getEnemyActions()) {
            actionsList.add(action.getDescription());
        }

        List<Map<String, Integer>> statisticModifiersList = new ArrayList<>();
        for (EnemyStatisticModifier entry : enemy.getEnemyStatisticModifiers()) {
            StatisticType statType = entry.getStatisticType();
            int points = entry.getPoints();

            Map<String, Integer> statEntry = new HashMap<>();
            statEntry.put(statType.getName(), points);

            statisticModifiersList.add(statEntry);
        }

        List<Map<String, Integer>> adjustedStatsList = IntStream.range(0, difficultyStatisticsList.size())
                .mapToObj(i -> mergeMaps(difficultyStatisticsList.get(i), statisticModifiersList.get(i)))
                .collect(Collectors.toList());

        EnemyDTO enemyDTO = new EnemyDTO(enemy.getName(), enemy.getDescription(), enemy.getEnemyDifficulty().getName(),
                adjustedStatsList, actionsList);

        return enemyDTO;
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1);
        map2.forEach((key, value) -> mergedMap.merge(key, value, Integer::sum));
        return mergedMap;
    }
}
