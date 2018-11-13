package ml.bondarev.iis.service;

import ml.bondarev.iis.dao.ScheduleDao;
import ml.bondarev.iis.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;


    @Override
    public List<Schedule> getListSchedule() {
        return scheduleDao.findAll();
    }

    @Override
    public List<Schedule> getListScheduleByGroupId(int id) {
        return scheduleDao.getListScheduleByGroupId(id);
    }

    @Override
    public void addSchedule(Schedule schedule) {
        scheduleDao.save(schedule);
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        scheduleDao.saveAndFlush(schedule);
    }

    @Override
    public Schedule getScheduleById(int id) {
        return scheduleDao.getOne(id);
    }

    @Override
    public void removeSchedule(int id) {
        scheduleDao.deleteById(id);
    }
}
