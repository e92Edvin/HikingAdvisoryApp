package com.tietoevry.hike.model;

import java.util.Map;

public record HikeInventoryResponse(String hikeComplexity, Map<String, String> hikeInventory) {
}
