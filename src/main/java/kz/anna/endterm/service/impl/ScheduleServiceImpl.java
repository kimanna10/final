package kz.anna.endterm.service.impl;

import kz.anna.endterm.entity.Schedule;
import kz.anna.endterm.repository.ScheduleRepository;
import kz.anna.endterm.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public void createSchedule(Schedule schedule) {
        scheduleRepository.saveAndFlush(schedule);
    }

    @Override
    public void updateSchedule(Long id, Schedule schedule) {
        Schedule userDb = scheduleRepository.findById(id).get();
        userDb.setDay1(schedule.getDay1());
        userDb.setDay2(schedule.getDay2());
        userDb.setDay3(schedule.getDay3());
        userDb.setTime1(schedule.getTime1());
        userDb.setTime2(schedule.getTime2());
        userDb.setTime3(schedule.getTime3());
        userDb.setTeam_id(schedule.getTeam_id());
        userDb.setRoom_id(schedule.getRoom_id());
        scheduleRepository.saveAndFlush(userDb);

    }

    @Override
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).get();
        scheduleRepository.delete(schedule);
    }
}
