package com.beantastic.api;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.beantastic.api.dao.BeanClassRepository;
import com.beantastic.api.dao.BeanClassStatisticsRepository;
import com.beantastic.api.dao.StatisticTypeRepository;
import com.beantastic.api.models.entities.BeanClass;
import com.beantastic.api.models.entities.BeanClassStatistic;
import com.beantastic.api.models.entities.StatisticType;

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
            StatisticType stat1Type = new StatisticType("Health", "The health points");
            StatisticType stat2Type = new StatisticType("Damage", "The attack points");
            StatisticType stat3Type = new StatisticType("Defense", "The block points");

            stat1Type = statisticTypeRepository.save(stat1Type);
            stat2Type = statisticTypeRepository.save(stat2Type);
            stat3Type = statisticTypeRepository.save(stat3Type);

            // Create and save the bean class
            BeanClass greenBean = new BeanClass("Green Bean", "tasty");

            greenBean.setBeanClassStatistics(new HashSet<>());
            greenBean = beanClassRepository.save(greenBean);

            // Create and save bean class statistics (junction table)
            BeanClassStatistic stat1 = new BeanClassStatistic(greenBean, stat1Type, 14);
            BeanClassStatistic stat2 = new BeanClassStatistic(greenBean, stat2Type, 20);
            BeanClassStatistic stat3 = new BeanClassStatistic(greenBean, stat3Type, 25);

            beanClassStatisticsRepository.save(stat1);
            beanClassStatisticsRepository.save(stat2);
            beanClassStatisticsRepository.save(stat3);

        };
    }
}
