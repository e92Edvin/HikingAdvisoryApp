package com.tietoevry.hike.service.impl;

import com.tietoevry.hike.constants.AppConstants;
import com.tietoevry.hike.model.HikeDetails;
import com.tietoevry.hike.model.ValidatedHikeDetails;
import com.tietoevry.hike.service.DistanceAnalyzer;
import com.tietoevry.hike.service.HikeDetailsEvaluationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class HikeInventoryAnalyzeServiceImplTest {

    @Test
    void testThatFetchInventoryReturnsHikeInventoryResponseAsString() {
        //TODO
    }

    @Test
    void testThatEvaluationServicesExecutedCorrectlyAndCollectedToSingleMap() {
        var hikeInventoryAnalyzeService = instantiateInventoryAnalyzeService();
        var resultingMap = hikeInventoryAnalyzeService.selectInventory(ValidatedHikeDetails.of(new HikeDetails(10d, "summer", "gravel")));
        var answersMap = Map.of("key1", "value1",
                        "key2", "value2",
                        "key3", "value3").entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> e.getValue().equals(resultingMap.get(e.getKey()))));

        answersMap.values().forEach(Assertions::assertTrue);
    }

    private HikeInventoryAnalyzeServiceImpl instantiateInventoryAnalyzeService() {
        return new HikeInventoryAnalyzeServiceImpl(Map.of(AppConstants.HIKE_COMPLEXITY,
                DistanceAnalyzer.HikeComplexity.MEDIUM.toString()),
                getEvaluationServices());
    }

    private List<HikeDetailsEvaluationService<Map<String, String>>> getEvaluationServices() {
        return List.of(
                input -> Map.of("key1", "value1"),
                input -> Map.of("key2", "value2"),
                input -> Map.of("key3", "value3")
        );
    }

}