package ml.bondarev.iis.service;

import ml.bondarev.iis.model.Day;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DayService {

    public Map<Date, List<Day>> getListDay();

    public void addDay(Day day);

    public void updateDay(Day day);

    public void removeDay(int id);

    public Day getDayById(int id);

}
