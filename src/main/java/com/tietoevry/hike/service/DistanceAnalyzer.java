package com.tietoevry.hike.service;

public abstract class DistanceAnalyzer<T> {

    public enum HikeComplexity {
        BEGINNER,
        MEDIUM,
        ADVANCED
    }

    public abstract HikeComplexity getHikeComplexityType();

    public abstract T collectHikeEquipment();

    public abstract boolean evaluate(Double distance);
}
