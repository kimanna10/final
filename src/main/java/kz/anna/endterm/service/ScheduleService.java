package kz.anna.endterm.service;

import kz.anna.endterm.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> getAllSchedules();
    void createSchedule(Schedule schedule);
    void updateSchedule(Long id, Schedule schedule);
    void deleteSchedule(Long id);
}
