package com.tietoevry.hike.controller;

import com.tietoevry.hike.model.HikeDetails;
import com.tietoevry.hike.model.ValidatedHikeDetails;
import com.tietoevry.hike.service.HikeInventoryAnalyzeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hike")
public class HikePlannerApi {

    private final HikeInventoryAnalyzeService hikeInventoryAnalyzeService;

    public HikePlannerApi(HikeInventoryAnalyzeService hikeInventoryAnalyzeService) {
        this.hikeInventoryAnalyzeService = hikeInventoryAnalyzeService;
    }

    @PostMapping("/inventory")
    public String fetchHikeInventory(@RequestBody HikeDetails hikeDetails) {
        return hikeInventoryAnalyzeService.fetchInventory(ValidatedHikeDetails.of(hikeDetails));
    }
}
