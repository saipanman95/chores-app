package com.mdrsolutions.chores.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Calendar;

/**
 *
 * @author mrodgers
 */
public class Group {
    private final String identifier;
    private final String description;
    private final Calendar createdAt;

    @JsonCreator
    public Group(
            @JsonProperty(value = "identifier") final String identifier, 
            @JsonProperty(value = "description") final String description, 
            @JsonProperty(value = "createdAt") final Calendar createdAt) {
        this.identifier = identifier;
        this.description = description;
        this.createdAt = createdAt;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }
    
    
}
