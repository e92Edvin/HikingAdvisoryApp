package com.tietoevry.hike.service.impl;

import com.tietoevry.hike.service.DistanceAnalyzer;
import com.tietoevry.hike.service.DistanceEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DistanceEvaluationServiceImpl implements DistanceEvaluationService {

    private final List<DistanceAnalyzer<Map<String, String>>> distanceAnalyzers;

    public DistanceEvaluationServiceImpl(List<DistanceAnalyzer<Map<String, String>>> distanceAnalyzers) {
        this.distanceAnalyzers = distanceAnalyzers;
    }

    @Override
    public List<DistanceAnalyzer<Map<String, String>>> fetchDistanceAnalyzers() {
        return distanceAnalyzers;
    }

}
