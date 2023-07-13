package com.tietoevry.hike.service.impl;

import com.tietoevry.hike.constants.InventoryDictionary;
import com.tietoevry.hike.service.DistanceAnalyzer;
import com.tietoevry.hike.service.MapDistanceAnalyzer;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class AdvancedDistanceAnalyzer extends MapDistanceAnalyzer {

    @Override
    public DistanceAnalyzer.HikeComplexity getHikeComplexityType() {
        return HikeComplexity.ADVANCED;
    }

    @Override
    public boolean evaluate(Double distance) {
        return distance > 100 && distance <= 1000;
    }

    @Override
    public Map<String, String> collectRequiredHikeInventory() {
        return Map.of(
                InventoryDictionary.LARGE_BAG, "1",
                InventoryDictionary.LITE_CAMPING_CHAIR, "1",
                InventoryDictionary.CAMPING_TENT, "1",
                InventoryDictionary.COOKING_SET, "1",
                InventoryDictionary.CAMPING_GAS_CYLINDER, "2",
                InventoryDictionary.LIGHTER, "1",
                InventoryDictionary.BOTTLE_OF_WATER, "8"
                // and etc...
        );
    }

}
