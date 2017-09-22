package com.mdrsolutions.chores.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;

/**
 *
 * @author mrodgers
 */
public class TaskCollection {

    @JsonCreator
    public TaskCollection(
            @JsonProperty(value = "dayOfWeekTasks") final Collection<DayOfWeekTask> dayOfWeekTasks, 
            @JsonProperty(value = "group") final Group group) {
        this.dayOfWeekTasks = dayOfWeekTasks;
        this.group = group;
    }
 
    private final Collection<DayOfWeekTask> dayOfWeekTasks;
    private final Group group;

    public Collection<DayOfWeekTask> getDayOfWeekTasks() {
        return this.dayOfWeekTasks;
    }

    public Group getGroup() {
        return group;
    }
    
    public void add(DayOfWeekTask dayOfWeekTask){
        getDayOfWeekTasks().add(dayOfWeekTask);
    }
}
