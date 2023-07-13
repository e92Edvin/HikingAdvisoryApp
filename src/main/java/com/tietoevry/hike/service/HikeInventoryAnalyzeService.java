package com.tietoevry.hike.service;

import com.tietoevry.hike.model.ValidatedHikeDetails;

public interface HikeInventoryAnalyzeService {

    String fetchInventory(ValidatedHikeDetails hikeDetails);
}
