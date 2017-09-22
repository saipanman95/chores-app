package com.mdrsolutions.chores.controller;

import com.mdrsolutions.chores.model.Group;
import com.mdrsolutions.chores.service.ChoresService;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mrodgers
 */
@RestController
public class ChoresController {

    @Autowired
    public ChoresController(ChoresService choresService) {
        this.choresService = choresService;
    }

    private final ChoresService choresService;

    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        model.put("tasks", choresService.loadChoresByGroup("1"));
        return model;
    }

    @RequestMapping("/resource/group/{groupId}/day/{dayId}/person/{personId}")
    public Map<String, Object> loadChoresByGroupDayPerson(
            @PathVariable("groupId") String groupId,
            @PathVariable("dayId") String dayId,
            @PathVariable("personId") String personId) {
        
        Map<String, Object> model = new HashMap<String, Object>();
        
        model.put("tasks", choresService.loadChoresByGroupDayPerson(groupId, personId, dayId));
        
        return model;
    }
    
    @RequestMapping("/resource/group/{groupId}/day/abbr/{dayId}/person/name/{personId}")
    public Map<String, Object> loadChoresByGroupDayPersonName(
            @PathVariable("groupId") String groupId,
            @PathVariable("dayId") String dayId,
            @PathVariable("personId") String personId) {
        
        Map<String, Object> model = new HashMap<String, Object>();
        
        model.put("tasks", choresService.loadChoresByGroupDayPersonName(groupId, personId, dayId));
        
        return model;
    }
}
