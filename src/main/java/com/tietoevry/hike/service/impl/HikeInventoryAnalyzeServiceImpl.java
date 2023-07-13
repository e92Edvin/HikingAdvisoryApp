package com.tietoevry.hike.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tietoevry.hike.constants.AppConstants;
import com.tietoevry.hike.exception.CannotConvertToTargetObjectException;
import com.tietoevry.hike.model.HikeInventoryResponse;
import com.tietoevry.hike.model.ValidatedHikeDetails;
import com.tietoevry.hike.service.HikeInventoryAnalyzeService;
import com.tietoevry.hike.service.HikeDetailsEvaluationService;
import com.tietoevry.hike.utils.JsonUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HikeInventoryAnalyzeServiceImpl implements HikeInventoryAnalyzeService {

    private final Map<String, String> hikeRequestContextHolder;
    private final  List<HikeDetailsEvaluationService<Map<String, String>>> evaluationServices;
    public HikeInventoryAnalyzeServiceImpl(Map<String, String> hikeRequestContextHolder, List<HikeDetailsEvaluationService<Map<String, String>>> evaluationServices) {
        this.hikeRequestContextHolder = hikeRequestContextHolder;
        this.evaluationServices = evaluationServices;
    }

    @Override
    public String fetchInventory(ValidatedHikeDetails hikeDetails) {
        try {
            return JsonUtil.toJson(new HikeInventoryResponse(hikeRequestContextHolder.get(AppConstants.HIKE_COMPLEXITY), selectInventory(hikeDetails)));
        } catch (JsonProcessingException e) {
            throw new CannotConvertToTargetObjectException(e);
        }
    }

    public Map<String, String> selectInventory(ValidatedHikeDetails hikeDetails) {
        return evaluationServices.stream()
                .map(service -> service.evaluate(hikeDetails))
                .flatMap(valuesMap -> valuesMap.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

}
