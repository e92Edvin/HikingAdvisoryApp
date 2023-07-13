package com.tietoevry.hike.service.impl;

import com.tietoevry.hike.constants.InventoryDictionary;
import com.tietoevry.hike.service.MapDistanceAnalyzer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MediumDistanceAnalyzer extends MapDistanceAnalyzer {
    @Override
    public HikeComplexity getHikeComplexityType() {
        return HikeComplexity.MEDIUM;
    }

    @Override
    public boolean evaluate(Double distance) {
        return distance > 25 && distance <= 100;
    }

    @Override
    public Map<String, String> collectRequiredHikeInventory() {
        return Map.of(
                InventoryDictionary.LARGE_BAG, "1",
                InventoryDictionary.LITE_CAMPING_CHAIR, "1",
                InventoryDictionary.CAMPING_TENT, "1",
                InventoryDictionary.COOKING_SET, "1",
                InventoryDictionary.BOTTLE_OF_WATER, "5"
                //etc...
        );
    }
}
