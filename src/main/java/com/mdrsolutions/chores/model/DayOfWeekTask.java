package com.mdrsolutions.chores.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;

/**
 *
 * @author mrodgers
 */
public class DayOfWeekTask {

    @JsonCreator
    public DayOfWeekTask(
            @JsonProperty(value = "day") final Day day, 
            @JsonProperty(value = "personTasks") final Collection<PersonTask> personTasks) {
        this.day = day;
        this.personTasks = personTasks;
    }

    private final Day day;
    private final Collection<PersonTask> personTasks;

    public Day getDay() {
        return day;
    }

    public Collection<PersonTask> getPersonTasks() {
        return personTasks;
    }

    public void add(PersonTask personTask) {
        getPersonTasks().add(personTask);
    }
}
