package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {

    List<Whisky> findWhiskiesFromParticularDistilleryWithSpecificAge(String name, int age);
    List<Whisky> findWhiskiesByRegion(String region);

}
