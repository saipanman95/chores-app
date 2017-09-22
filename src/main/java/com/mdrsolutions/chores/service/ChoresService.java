package com.mdrsolutions.chores.service;

import com.google.common.collect.Lists;
import com.mdrsolutions.chores.model.Day;
import com.mdrsolutions.chores.model.DayOfWeekTask;
import com.mdrsolutions.chores.model.Group;
import com.mdrsolutions.chores.model.Person;
import com.mdrsolutions.chores.model.PersonTask;
import com.mdrsolutions.chores.model.Task;
import com.mdrsolutions.chores.model.TaskCollection;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author mrodgers
 */
@Service
public class ChoresService {

    @Value("${chores.location}")
    private String jsonLocation = "https://s3.us-east-2.amazonaws.com/mdrsolutions-chores/sample.json";

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<TaskCollection> loadChoresByGroup(String groupId) {
        return restTemplate.getForEntity(jsonLocation, TaskCollection.class);
    }

    public TaskCollection loadChoresByGroupDayPerson(String groupId, String personId, String dayId) {
        ResponseEntity<TaskCollection> entity = restTemplate.getForEntity(jsonLocation, TaskCollection.class);
        TaskCollection body = entity.getBody();
        Collection<DayOfWeekTask> dayOfWeekTasks = body.getDayOfWeekTasks();
        
        List<Task> filteredDayPersonTasks = Lists.newArrayList();
        Person filteredPerson = null;
        Day filteredDay = null;
        
        for(DayOfWeekTask dowt : dayOfWeekTasks){
            if(dowt.getDay().getId().equalsIgnoreCase(dayId)){
                filteredDay = dowt.getDay();
                for(PersonTask pt : dowt.getPersonTasks()){
                    if(personId.equalsIgnoreCase(pt.getPerson().getId())){
                        filteredDayPersonTasks.addAll(pt.getTasks());
                        filteredPerson = pt.getPerson();
                        break;
                    }
                }
                break;
            }
        }
        PersonTask filteredPersonTask = new PersonTask(filteredPerson, filteredDayPersonTasks);
        DayOfWeekTask filteredDayOfWeekTask = new DayOfWeekTask(filteredDay, Lists.newArrayList(filteredPersonTask));
        return new TaskCollection(Lists.newArrayList(filteredDayOfWeekTask), body.getGroup());
    }

    public Object loadChoresByGroupDayPersonName(String groupId, String personId, String dayId) {
        ResponseEntity<TaskCollection> entity = restTemplate.getForEntity(jsonLocation, TaskCollection.class);
        TaskCollection body = entity.getBody();
        Collection<DayOfWeekTask> dayOfWeekTasks = body.getDayOfWeekTasks();
        
        List<Task> filteredDayPersonTasks = Lists.newArrayList();
        Person filteredPerson = null;
        Day filteredDay = null;
        
        for(DayOfWeekTask dowt : dayOfWeekTasks){
            if(dowt.getDay().getAbbr().equalsIgnoreCase(dayId)){
                filteredDay = dowt.getDay();
                for(PersonTask pt : dowt.getPersonTasks()){
                    if(personId.equalsIgnoreCase(pt.getPerson().getName())){
                        filteredDayPersonTasks.addAll(pt.getTasks());
                        filteredPerson = pt.getPerson();
                        break;
                    }
                }
                break;
            }
        }
        PersonTask filteredPersonTask = new PersonTask(filteredPerson, filteredDayPersonTasks);
        DayOfWeekTask filteredDayOfWeekTask = new DayOfWeekTask(filteredDay, Lists.newArrayList(filteredPersonTask));
        return new TaskCollection(Lists.newArrayList(filteredDayOfWeekTask), body.getGroup());
    }
}
