package com.tietoevry.hike.service.impl;

import com.tietoevry.hike.service.DistanceAnalyzer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedDistanceAnalyzerTest {

    @Test
    void testThatAdvancedHikeComplexityReturnsAdvancedType() {
        var distanceAnalyzer = new AdvancedDistanceAnalyzer();
        assertEquals(DistanceAnalyzer.HikeComplexity.ADVANCED, distanceAnalyzer.getHikeComplexityType());
    }

    @Test
    void testThatAdvancedEvaluationIsHigherThan_100_andLessOrEqualTo_1000() {
        var distanceAnalyzer = new AdvancedDistanceAnalyzer();
        assertTrue(distanceAnalyzer.evaluate(100.01));
        assertTrue(distanceAnalyzer.evaluate(1000d));
        assertFalse(distanceAnalyzer.evaluate(100d));
        assertFalse(distanceAnalyzer.evaluate(1000.01));
    }

    @Test
    void testThatRequiredInventory() {
        //TODO
    }

}