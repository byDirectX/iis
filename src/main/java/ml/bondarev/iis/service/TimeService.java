package ml.bondarev.iis.service;

import ml.bondarev.iis.model.Time;

import java.util.List;

public interface TimeService {

    public List<Time> getTimeList();

    public void addTime(Time time);

    public void updateTime(Time time);

    public Time getTimeById(int id);

    public void removeTime(int id);

}
