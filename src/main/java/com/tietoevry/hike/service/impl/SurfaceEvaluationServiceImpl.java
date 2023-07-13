package com.tietoevry.hike.service.impl;

import com.tietoevry.hike.model.ValidatedHikeDetails;
import com.tietoevry.hike.service.SurfaceEvaluationService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SurfaceEvaluationServiceImpl implements SurfaceEvaluationService {
    @Override
    public Map<String, String> evaluate(ValidatedHikeDetails validatedHikeDetails) {
        return switch (validatedHikeDetails.getSurface()) {
            //TODO : move to strings into Inventory Dictionary
            case GRAVEL, GRASS -> Map.of("Sneakers", "1");
            case SAND -> Map.of("Strappy Sandals", "1");
            case ASPHALT -> Map.of("Trainers ", "1");
            //etc...
        };
    }
}
