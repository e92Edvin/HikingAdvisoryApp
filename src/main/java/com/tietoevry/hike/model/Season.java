package com.tietoevry.hike.model;

import java.util.Map;

public enum Season {
    SUMMER {
        @Override
        public Map<String, String> requiredTools() {
            return Map.of(
                    "Sunglasses", "1",
                    "Cap", "1"
            );
        }
    }, AUTUMN {
        @Override
        public Map<String, String> requiredTools() {
            return Map.of(
                    "Cloak", "1"
            );
        }
    }, WINTER {
        @Override
        public Map<String, String> requiredTools() {
            return Map.of(
                    "Earmuffs", "1",
                    "Headband", "1",
                    "Shell Jacket", "1"
            );
        }
    }, SPRING {
        @Override
        public Map<String, String> requiredTools() {
            return Map.of(
                    "Windproof Jacket", "1"
            );
        }
    };

    public abstract Map<String, String> requiredTools();
}
