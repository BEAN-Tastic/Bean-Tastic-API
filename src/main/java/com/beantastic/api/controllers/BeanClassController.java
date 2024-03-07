package com.beantastic.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beantastic.api.dao.BeanClassRepository;
import com.beantastic.api.models.entities.BeanClass;

@RestController
public class BeanClassController {

    private final BeanClassRepository beanClassRepository;

    public BeanClassController(BeanClassRepository beanClassRepository) {
        this.beanClassRepository = beanClassRepository;

    }

    @GetMapping("/beanClasses")
    public Iterable<BeanClass> getAllBeanClasses() {
        return beanClassRepository.findAll();
    }

}