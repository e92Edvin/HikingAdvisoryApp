package com.tietoevry.hike.model;

import com.tietoevry.hike.exception.IllegalDistanceInputException;

import java.util.stream.Stream;

public class ValidatedHikeDetails {
    private final Double distance;
    private final Season season;
    private final Surface surface;

    private ValidatedHikeDetails(Double distance, Season season, Surface surface) {
        this.distance = distance;
        this.surface = surface;
        this.season = season;
    }

    public static ValidatedHikeDetails of(HikeDetails hikeDetails) {
        assertDistanceIsNonNegativeValue(hikeDetails.distance());
        assertSeasonIsCorrect(hikeDetails.season());
        assertSurfaceIsCorrect(hikeDetails.surface());
        //TODO: additional validations
        return new ValidatedHikeDetails(hikeDetails.distance(),
                Season.valueOf(hikeDetails.season().toUpperCase()),
                Surface.valueOf(hikeDetails.surface().toUpperCase()));
    }

    private static void assertDistanceIsNonNegativeValue(Double distance) {
        if (distance <= 0d) {
            throw new IllegalDistanceInputException("Hmmm, probably you made a mistake with distance input data:" + distance);
        }
    }

    private static void assertSeasonIsCorrect(String season) {
        Stream.of(Season.values())
                .filter(enumSeason -> enumSeason.name().equalsIgnoreCase(season))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("This app does not support this season: %s", season)));
    }

    private static void assertSurfaceIsCorrect(String surface) {
        Stream.of(Surface.values())
                .filter(enumSurface -> enumSurface.name().equalsIgnoreCase(surface))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("This app does not know this surface: %s", surface)));
    }

    public Double getDistance() {
        return distance;
    }

    public Season getSeason() {
        return season;
    }

    public Surface getSurface() {
        return surface;
    }
}
