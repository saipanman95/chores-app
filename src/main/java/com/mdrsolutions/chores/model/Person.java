package com.mdrsolutions.chores.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author mrodgers
 */
public class Person {
    private final String id;
    private final String name;
    private final Group group;

    @JsonCreator
    public Person(
            @JsonProperty(value = "id") final String id, 
            @JsonProperty(value = "name") final String name, 
            @JsonProperty(value = "group") final Group group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }
    
    
}
