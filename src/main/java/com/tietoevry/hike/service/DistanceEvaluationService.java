package com.tietoevry.hike.service;

import com.tietoevry.hike.exception.IllegalDistanceInputException;
import com.tietoevry.hike.model.ValidatedHikeDetails;

import java.util.List;
import java.util.Map;

public interface DistanceEvaluationService extends HikeDetailsEvaluationService<Map<String, String>>{
    default Map<String, String> evaluate(ValidatedHikeDetails distance) {
        return fetchDistanceAnalyzers().stream()
                .filter(distanceAnalyzer -> distanceAnalyzer.evaluate(distance.getDistance()))
                .findFirst()
                .orElseThrow(() -> new IllegalDistanceInputException("This app only supports human hikes :)"))
                .collectHikeEquipment();
    }

    List<DistanceAnalyzer<Map<String, String>>> fetchDistanceAnalyzers();
}
