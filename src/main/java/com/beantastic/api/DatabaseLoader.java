package com.beantastic.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.beantastic.api.models.entities.BeanClass;
import com.beantastic.api.models.entities.BeanClassStatistics;
import com.beantastic.api.models.entities.StatisticType;
import com.beantastic.api.repositories.BeanClassRepository;
import com.beantastic.api.repositories.BeanClassStatisticsRepository;
import com.beantastic.api.repositories.StatisticTypeRepository;

@Component
public class DatabaseLoader {

    private final BeanClassRepository beanClassRepository;
    private final StatisticTypeRepository statisticTypeRepository;
    private final BeanClassStatisticsRepository beanClassStatisticsRepository;

    @Autowired
    public DatabaseLoader(BeanClassRepository beanClassRepository, StatisticTypeRepository statisticTypeRepository,
            BeanClassStatisticsRepository beanClassStatisticsRepository) {
        this.beanClassRepository = beanClassRepository;
        this.statisticTypeRepository = statisticTypeRepository;
        this.beanClassStatisticsRepository = beanClassStatisticsRepository;
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            // Create and save the 3 statistic types
            StatisticType stat1Type = new StatisticType("Health", "The health power");
            StatisticType stat2Type = new StatisticType("Damage", "The attack power");
            StatisticType stat3Type = new StatisticType("Defense", "The block power");

            stat1Type = statisticTypeRepository.save(stat1Type);
            stat2Type = statisticTypeRepository.save(stat2Type);
            stat3Type = statisticTypeRepository.save(stat3Type);

            // Create and save the bean class
            BeanClass greenBean = new BeanClass("Green Bean", "tasty");

            greenBean = beanClassRepository.save(greenBean);

            // Create and save bean class statistics (junction table)
            BeanClassStatistics stat1 = new BeanClassStatistics(greenBean, stat1Type, 14);
            BeanClassStatistics stat2 = new BeanClassStatistics(greenBean, stat2Type, 14);
            BeanClassStatistics stat3 = new BeanClassStatistics(greenBean, stat3Type, 14);

            beanClassStatisticsRepository.save(stat1);
            beanClassStatisticsRepository.save(stat2);
            beanClassStatisticsRepository.save(stat3);

        };
    }
}
