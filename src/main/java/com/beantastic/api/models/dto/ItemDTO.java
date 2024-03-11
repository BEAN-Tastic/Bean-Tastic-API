package com.beantastic.api.models.dto;

import java.util.*;
import lombok.*;

@Data
@AllArgsConstructor
public class ItemDTO {

    private String name;

    private String description;

    private String quality;

    private List<Map<String, Integer>> itemClassStatistics;

}
