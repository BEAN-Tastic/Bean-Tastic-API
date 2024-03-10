package com.beantastic.api.controllers;

import java.util.*;
import java.util.stream.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.beantastic.api.dao.BeanClassRepository;
import com.beantastic.api.models.dto.BeanClassDTO;

@RestController
public class BeanClassController {

    private final BeanClassRepository beanClassRepository;

    public BeanClassController(BeanClassRepository beanClassRepository) {
        this.beanClassRepository = beanClassRepository;

    }

    @GetMapping("/beanClasses")
    public ResponseEntity<?> getAllBeanClasses() {

        try {
            List<BeanClassDTO> beanDTOClasses = StreamSupport.stream(beanClassRepository.findAll().spliterator(), false)
                    .map(BeanClassDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(beanDTOClasses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());

        }

    }
}