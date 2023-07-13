package com.tietoevry.hike.service;

import com.tietoevry.hike.constants.AppConstants;
import com.tietoevry.hike.constants.InventoryDictionary;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class MapDistanceAnalyzer extends DistanceAnalyzer<Map<String, String>> {
    private final Map<String, String> HIKE_MUST_HAVE_TOOLS = Map.of(
            InventoryDictionary.CAMPING_BACKPACK, "1",
            InventoryDictionary.MOBILE_PHONE, "1",
            InventoryDictionary.FIRST_AID_KIT, "1"
            //TODO: add required things
    );

    @Autowired
    protected Map<String, String> hikeRequestContextHolder;

    @Override
    public Map<String, String> collectHikeEquipment() {
        setHikeComplexity();
        return Stream.concat(HIKE_MUST_HAVE_TOOLS.entrySet().stream(),
                        collectRequiredHikeInventory().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private void setHikeComplexity() {
        hikeRequestContextHolder.put(AppConstants.HIKE_COMPLEXITY, getHikeComplexityType().toString());
    }

    protected abstract Map<String, String> collectRequiredHikeInventory();

}
