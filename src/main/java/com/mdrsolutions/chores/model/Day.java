package com.mdrsolutions.chores.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author mrodgers
 */
public class Day {

    @JsonCreator
    public Day(
            @JsonProperty(value = "id") final String id,
            @JsonProperty(value = "name") final String name,
            @JsonProperty(value = "abbr") final String abbr) {
        this.id = id;
        this.name = name;
        this.abbr = abbr;
    }

    private final String id;
    private final String name;
    private final String abbr;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbbr() {
        return abbr;
    }

}
