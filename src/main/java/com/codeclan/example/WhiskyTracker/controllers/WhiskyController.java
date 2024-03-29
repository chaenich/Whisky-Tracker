package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
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
    public List<Whisky> findWhiskyByYear(@PathVariable int year) {
        return whiskyRepository.findWhiskyByYear(year);
    }

    @GetMapping(value = "/distage/{name}/{age}")
    public List<Whisky> findWhiskiesFromParticularDistilleryWithSpecificAge(@PathVariable String name, @PathVariable int age) {
        return whiskyRepository.findWhiskiesFromParticularDistilleryWithSpecificAge(name, age);
    }

    @GetMapping(value = "/region/{region}/")
    public List<Whisky> findWhiskiesByRegion(@PathVariable String region) {
        return whiskyRepository.findWhiskiesByRegion(region);
    }
}
