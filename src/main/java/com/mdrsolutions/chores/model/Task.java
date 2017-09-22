package com.mdrsolutions.chores.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author mrodgers
 */
public class Task {
@JsonCreator
    public Task(
            @JsonProperty(value = "id") final String id, 
            @JsonProperty(value = "title") final String title, 
            @JsonProperty(value = "description") final String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    
    private final String id;
    private final String title;
    private final String description;

    public String getId() {
        return id;
    } 
    
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
}
