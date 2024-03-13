package com.beantastic.api.models.dto;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnemyDTO {

    private String name;

    private String description;

    private String difficulty;

    private List<Map<String, Integer>> difficultyStatistics;

    private List<String> actions;

    private List<Map<String, Integer>> statisticModifiers;

}
