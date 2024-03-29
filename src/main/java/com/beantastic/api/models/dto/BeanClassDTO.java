package com.beantastic.api.models.dto;

import java.util.*;

import lombok.*;

@Data
@AllArgsConstructor
public class BeanClassDTO {

    private String name;

    private String description;

    private List<Map<String, Integer>> beanClassStatistics;

}
