package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;


    @GetMapping(value = "/year/{year}")
    public List<Whisky> findWhiskiesWithYear(@PathVariable int year){
        return whiskyRepository.findWhiskiesWithYear(year);
    }

    @GetMapping(value = "/distilleries/{id}/age/{age}")
    public List<Whisky>findWhiskiesWithAge(@PathVariable int age, @PathVariable Long id){
        return whiskyRepository.findWhiskiesWithAge(age, id);
    }
}
