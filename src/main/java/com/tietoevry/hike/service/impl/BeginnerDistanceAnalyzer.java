package com.tietoevry.hike.service.impl;

import com.tietoevry.hike.constants.InventoryDictionary;
import com.tietoevry.hike.service.MapDistanceAnalyzer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BeginnerDistanceAnalyzer extends MapDistanceAnalyzer {
    @Override
    public HikeComplexity getHikeComplexityType() {
        return HikeComplexity.BEGINNER;
    }

    @Override
    public boolean evaluate(Double distance) {
        return distance <= 25;
    }

    @Override
    public Map<String, String> collectRequiredHikeInventory() {
        return Map.of(
                InventoryDictionary.BOTTLE_OF_WATER, "1",
                InventoryDictionary.SNACKS, "1"
        );
    }

}
