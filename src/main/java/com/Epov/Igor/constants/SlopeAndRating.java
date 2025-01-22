package com.Epov.Igor.constants;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
final public class SlopeAndRating {
    private final Map<String, SlopeRating> mens = new HashMap<>();
    private final Map<String, SlopeRating> women = new HashMap<>();

    public SlopeAndRating() {
        mens.put("green", new SlopeRating(73.0f, 133));
        mens.put("black", new SlopeRating(71.5f, 130));
        mens.put("blue", new SlopeRating(69.9f, 128));
        mens.put("white", new SlopeRating(67.3f, 124));
        mens.put("yellow", new SlopeRating(64.8f, 118));

        women.put("blue", new SlopeRating(75.8f, 139));
        women.put("white", new SlopeRating(73.0f, 133));
        women.put("yellow", new SlopeRating(69.8f, 123));
    }
}
