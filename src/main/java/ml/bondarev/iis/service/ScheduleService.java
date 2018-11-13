package ml.bondarev.iis.service;

import ml.bondarev.iis.model.Schedule;

import java.util.List;

public interface ScheduleService {

    public List<Schedule> getListSchedule();

    public List<Schedule> getListScheduleByGroupId(int id);

    public void addSchedule(Schedule schedule);

    public void updateSchedule(Schedule schedule);

    public Schedule getScheduleById(int id);

    public void removeSchedule(int id);

}
