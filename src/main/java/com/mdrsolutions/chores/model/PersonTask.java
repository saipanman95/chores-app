package com.mdrsolutions.chores.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;

/**
 *
 * @author mrodgers
 */
public class PersonTask {

    @JsonCreator
    public PersonTask(
            @JsonProperty(value = "person") final Person person,
            @JsonProperty(value = "tasks") final Collection<Task> tasks) {
        this.person = person;
        this.tasks = tasks;
    }

    private final Person person;
    private final Collection<Task> tasks;

    public Person getPerson() {
        return person;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public void add(Task task) {
        getTasks().add(task);
    }
}
