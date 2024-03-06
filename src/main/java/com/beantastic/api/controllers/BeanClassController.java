package com.beantastic.api.controllers;

import com.beantastic.api.models.entities.BeanClass;
import com.beantastic.api.models.entities.BeanClassStatistics;
import com.beantastic.api.repositories.BeanClassRepository;
import com.beantastic.api.repositories.BeanClassStatisticsRepository;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanClassController {

    private final BeanClassRepository beanClassRepository;
    private final BeanClassStatisticsRepository beanClassStatisticsRepository;

    public BeanClassController(BeanClassRepository beanClassRepository,
            BeanClassStatisticsRepository beanClassStatisticsRepository) {
        this.beanClassRepository = beanClassRepository;
        this.beanClassStatisticsRepository = beanClassStatisticsRepository;
    }

    @GetMapping("/getBeanClasses")
    public List<BeanClass> getAllBeanClasses() {
        List<BeanClass> beanClasses = new ArrayList<>();
        beanClassRepository.findAll().forEach(beanClasses::add);
        return beanClasses;
    }

    @GetMapping("/getBeanClassStatistics")
    public List<BeanClassStatistics> getBeanClassStatistics() {
        List<BeanClassStatistics> beanClasses = new ArrayList<>();
        beanClassStatisticsRepository.findAll().forEach(beanClasses::add);

        return beanClasses;

    }
}