package ml.bondarev.iis.service;

import ml.bondarev.iis.model.Time;
import ml.bondarev.iis.dao.TimeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeDao timeDao;


    @Override
    public List<Time> getTimeList() {
        return timeDao.findAll();
    }

    @Override
    public void addTime(Time time) {
        timeDao.save(time);
    }

    @Override
    public void updateTime(Time time) {
        timeDao.saveAndFlush(time);
    }

    @Override
    public Time getTimeById(int id) {
        return timeDao.getOne(id);
    }

    @Override
    public void removeTime(int id) {
        timeDao.deleteById(id);
    }

}
