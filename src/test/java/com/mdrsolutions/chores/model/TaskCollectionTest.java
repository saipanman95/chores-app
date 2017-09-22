/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.chores.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import com.google.common.collect.Lists;
import java.util.Calendar;

/**
 *
 * @author mrodgers
 */
public class TaskCollectionTest {

    @Test
    public void setUp() throws JsonProcessingException {
        Task vacMainLevel = new Task("1","Vacuum main level", "Vacuum and sweep floors on the main level. This means kitchen, living room, dinning room, entry way, and hall");
        Task vacUpstairsLevel = new Task("2","Vacuum Upstairs level", "Vacuum and sweep floors upstairs where bedrooms are located. This includes all bedrooms and hallway. Pickup clutter to complete this task");
        Task vacBaseLevel = new Task("3","Vacuum Basement level", "Vacuum and sweep floors in basement. This includes all rooms and office.");
        Task vacBaseStairs = new Task("4","Vacuum Basement Stairs", "Vacuum stairs leading to basement with dirt devil");
        Task vacMainStairs = new Task("5","Vacuum Main Stairs", "Vacuum stairs leading up stairs with dirt devil");
        Task cleanPowderRoom = new Task("6","Clean Powder room", "Clean powder room on main level.  This includes toilet, floors, sink and mirror; empty trash as well.");
        Task cleanUpstairsBath = new Task("7","Clean Upstairs bathroom", "Clean powder room on main level.  This includes toilet, floors, sink and mirror; empty trash as well.");
        Task cleanBasementBath = new Task("8","Clean Basement bathroom", "Clean powder room on main level.  This includes toilet, floors, sink and mirror; empty trash as well.");
        Task washDishes = new Task("9","Wash Dishes", "Washing dishes means to empty the dishwasher and then put dirty dished in after they have had all debree removed");
        Task wipeCounterTops = new Task("10","Wipe counter tops", "Wipe counter tops and tables; dinning room and kitchen - not onto the floor");
        Task washingLaundry = new Task("11","Washing Laundry", "Take dirty laundry by lights/darks and put in the washing machine.  Do not overload. Put clean clothes in dryer.  Put dry clothes on bed to be folded");
        Task foldingLaundry = new Task("12","Folding Laundry", "Take dry clothes on bed, fold and separate into piles. Please take your pile");
        Task putLaundryAway = new Task("13","Putting Laundry Away", "Take your folded clothes and put them away neatly");
        Task cleanYourRoom = new Task("14","Clean Your Room", "This means make your bed, pick up dirty laundry and towels, paper, wrappers, toys, etc...");
        Task takeOutTrash = new Task("15","Empty Kitchen Trash", "Empty Kitchen trash, and put new bag in trash can");

        Group rodgersGroup = new Group("1", "rodgers clan", Calendar.getInstance());
        Person michael = new Person("1", "Michael", rodgersGroup);
        Person theodore = new Person("2", "Theodore", rodgersGroup);
        Person avelina = new Person("3", "Avelina", rodgersGroup);
        Person haani = new Person("4", "Ha'ani", rodgersGroup);
        
        Day sunday = new Day("1","Sunday", "Sun");
        Day monday = new Day("2","Monday", "Mon");
        Day tuesday = new Day("3","Tuesday", "Tue");
        Day wednesday = new Day("4","Wednesday", "Wed");
        Day thursday = new Day("5","Thursday", "Thu");
        Day friday = new Day("6","Friday", "Fri");
        Day saturday = new Day("7","Saturday", "Sat");

        PersonTask sundayMichaelTasks = new PersonTask(michael, Lists.newArrayList(vacBaseLevel, cleanPowderRoom, washDishes, washingLaundry, foldingLaundry, putLaundryAway, cleanYourRoom, takeOutTrash));
        PersonTask mondayMichaelTasks = new PersonTask(michael, Lists.newArrayList(vacMainLevel, cleanBasementBath, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask tuesdayMichaelTasks = new PersonTask(michael, Lists.newArrayList(vacBaseLevel, cleanUpstairsBath, wipeCounterTops, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask wednesdayMichaelTasks = new PersonTask(michael, Lists.newArrayList(vacUpstairsLevel, vacUpstairsLevel, foldingLaundry, putLaundryAway, cleanYourRoom, takeOutTrash));
        PersonTask thursdayMichaelTasks = new PersonTask(michael, Lists.newArrayList(vacMainLevel, cleanPowderRoom, cleanBasementBath, wipeCounterTops, washingLaundry, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask fridayMichaelTasks = new PersonTask(michael, Lists.newArrayList(washDishes, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask saturdayMichaelTasks = new PersonTask(michael, Lists.newArrayList(vacMainLevel, foldingLaundry, putLaundryAway, cleanYourRoom, takeOutTrash));

        PersonTask sundayHaaniTasks = new PersonTask(haani, Lists.newArrayList(vacMainLevel, cleanBasementBath, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask mondayHaaniTasks = new PersonTask(haani, Lists.newArrayList(vacUpstairsLevel, vacBaseLevel, cleanPowderRoom, washingLaundry, foldingLaundry, putLaundryAway, cleanYourRoom, takeOutTrash));
        PersonTask tuesdayHaaniTasks = new PersonTask(haani, Lists.newArrayList(vacUpstairsLevel, washDishes, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask wednesdayHaaniTasks = new PersonTask(haani, Lists.newArrayList(vacMainLevel, cleanUpstairsBath, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask thursdayHaaniTasks = new PersonTask(haani, Lists.newArrayList(vacBaseLevel, foldingLaundry, putLaundryAway, cleanYourRoom, takeOutTrash));
        PersonTask fridayHaaniTasks = new PersonTask(haani, Lists.newArrayList(vacUpstairsLevel, cleanPowderRoom, cleanBasementBath, washingLaundry, foldingLaundry, putLaundryAway, cleanYourRoom, takeOutTrash));
        PersonTask saturdayHaaniTasks = new PersonTask(haani, Lists.newArrayList(washDishes, washingLaundry, foldingLaundry, putLaundryAway, cleanYourRoom, takeOutTrash));

        PersonTask sundayTheoTasks = new PersonTask(theodore, Lists.newArrayList(vacUpstairsLevel, cleanUpstairsBath, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask mondayTheoTasks = new PersonTask(theodore, Lists.newArrayList(washDishes, wipeCounterTops, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask tuesdayTheoTasks = new PersonTask(theodore, Lists.newArrayList(cleanPowderRoom, washingLaundry, foldingLaundry, putLaundryAway, cleanYourRoom, takeOutTrash));
        PersonTask wednesdayTheoTasks = new PersonTask(theodore, Lists.newArrayList(vacBaseLevel, cleanBasementBath, washDishes, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask thursdayTheoTasks = new PersonTask(theodore, Lists.newArrayList(vacMainLevel, vacUpstairsLevel, cleanUpstairsBath, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask fridayTheoTasks = new PersonTask(theodore, Lists.newArrayList(vacMainLevel, vacBaseLevel, wipeCounterTops, foldingLaundry, putLaundryAway, cleanYourRoom, takeOutTrash));
        PersonTask saturdayTheoTasks = new PersonTask(theodore, Lists.newArrayList(vacUpstairsLevel, vacBaseLevel, washingLaundry, foldingLaundry, putLaundryAway, cleanYourRoom, takeOutTrash));

        PersonTask sundayAvelinaTasks = new PersonTask(avelina, Lists.newArrayList(wipeCounterTops, vacBaseStairs, vacMainStairs, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask mondayAvelinaTasks = new PersonTask(avelina, Lists.newArrayList(cleanUpstairsBath, vacBaseStairs, vacMainStairs, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask tuesdayAvelinaTasks = new PersonTask(avelina, Lists.newArrayList(cleanBasementBath, vacBaseStairs, vacMainStairs, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask wednesdayAvelinaTasks = new PersonTask(avelina, Lists.newArrayList(cleanPowderRoom, wipeCounterTops, vacBaseStairs, vacMainStairs, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask thursdayAvelinaTasks = new PersonTask(avelina, Lists.newArrayList(washDishes, vacBaseStairs, vacMainStairs, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask fridayAvelinaTasks = new PersonTask(avelina, Lists.newArrayList(cleanUpstairsBath, vacBaseStairs, vacMainStairs, foldingLaundry, putLaundryAway, cleanYourRoom));
        PersonTask saturdayAvelinaTasks = new PersonTask(avelina, Lists.newArrayList(cleanPowderRoom, cleanUpstairsBath, cleanBasementBath, wipeCounterTops, washingLaundry, vacBaseStairs, vacMainStairs, foldingLaundry, putLaundryAway, cleanYourRoom, takeOutTrash));

        TaskCollection taskCollection = new TaskCollection(
                Lists.newArrayList(
                        new DayOfWeekTask(sunday, Lists.newArrayList(sundayAvelinaTasks, sundayHaaniTasks, sundayMichaelTasks, sundayTheoTasks)),
                        new DayOfWeekTask(monday, Lists.newArrayList(mondayAvelinaTasks, mondayHaaniTasks, mondayMichaelTasks, mondayTheoTasks)),
                        new DayOfWeekTask(tuesday, Lists.newArrayList(tuesdayAvelinaTasks, tuesdayHaaniTasks, tuesdayMichaelTasks, tuesdayTheoTasks)),
                        new DayOfWeekTask(wednesday, Lists.newArrayList(wednesdayAvelinaTasks, wednesdayHaaniTasks, wednesdayMichaelTasks, wednesdayTheoTasks)),
                        new DayOfWeekTask(thursday, Lists.newArrayList(thursdayAvelinaTasks, thursdayHaaniTasks, thursdayMichaelTasks, thursdayTheoTasks)),
                        new DayOfWeekTask(friday, Lists.newArrayList(fridayAvelinaTasks, fridayHaaniTasks, fridayMichaelTasks, fridayTheoTasks)),
                        new DayOfWeekTask(saturday, Lists.newArrayList(saturdayAvelinaTasks, saturdayHaaniTasks, saturdayMichaelTasks, saturdayTheoTasks))
                ),
                rodgersGroup);

        ObjectMapper om = new ObjectMapper();
        String writeValueAsString = om.writeValueAsString(taskCollection);
        System.out.println(writeValueAsString);
    }

}
