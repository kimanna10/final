package kz.anna.endterm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.anna.endterm.entity.Schedule;
import kz.anna.endterm.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@Api(value = "ScheduleControllerClass", description = "This class allows to interact with Schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/all")  //  get all choreographers from db
    @ApiOperation(value = "Method to get list of schedules", response = List.class)
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/create")
    @ApiOperation(value = "Method to create schedules by GET", response = List.class)
    public void createScheduleBy(@RequestParam("day1") String day1,@RequestParam("day2") String day2, @RequestParam("day3") String day3,@RequestParam("time1") String time1,@RequestParam("time2")String time2,@RequestParam("time3")String time3,
                                 @RequestParam("room_id") Long room_id, @RequestParam("team_id")Long team_id) {
        Schedule schedule = new Schedule();
        schedule.setDay1(day1);
        schedule.setDay2(day2);
        schedule.setDay3(day3);
        schedule.setTime1(time1);
        schedule.setTime2(time2);
        schedule.setTime3(time3);
        schedule.setRoom_id(room_id);
        schedule.setTeam_id(team_id);

        scheduleService.createSchedule(schedule);
    }

    @PostMapping
    @ApiOperation(value = "Method to create schedules by POST", response = List.class)
    public void createSchedule(@RequestBody Schedule schedule) {
        System.out.println("ScheduleController.createSchedule");
        System.out.println("schedule = " + schedule);

        scheduleService.createSchedule(schedule);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Method to update schedules", response = List.class)
    public void updateSchedule(@PathVariable Long id,
                                    @RequestBody Schedule schedule) {

        System.out.println("ScheduleController.updateSchedule");
        System.out.println("id = " + id);

        scheduleService.updateSchedule(id, schedule);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Method to delete schedules", response = List.class)
    public void deleteSchedule(@PathVariable Long id) {

        System.out.println("ScheduleController.deleteSchedule");
        System.out.println("id = " + id);

        scheduleService.deleteSchedule(id);
    }
}
