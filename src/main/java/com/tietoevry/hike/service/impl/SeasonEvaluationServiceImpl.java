package com.tietoevry.hike.service.impl;

import com.tietoevry.hike.model.ValidatedHikeDetails;
import com.tietoevry.hike.service.SeasonEvaluationService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SeasonEvaluationServiceImpl implements SeasonEvaluationService {
    @Override
    public Map<String, String> evaluate(ValidatedHikeDetails validatedHikeDetails) {
        return validatedHikeDetails.getSeason().requiredTools();
    }
}
