package ml.bondarev.iis.service;

import ml.bondarev.iis.dao.DayDao;
import ml.bondarev.iis.model.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private DayDao dayDao;

    @Override
    public Map<Date, List<Day>> getListDay() {
        List<Day> dayList = dayDao.findAll();
        Set<Date> dateSet = new TreeSet<>();
        Map<Date, List<Day>> sortedDayList = new HashMap<>();

        for (Day d: dayList) {
            dateSet.add(d.getDate());
        }

        Iterator setIterator = dateSet.iterator();

        while (setIterator.hasNext()) {
            Date date = (Date) setIterator.next();
            List<Day> tempList = new ArrayList<>();

            for (Day d: dayList) {
                if ((date).equals(d.getDate())) {
                    tempList.add(d);
                }
            }
            sortedDayList.put(date, tempList);
        }

        return sortedDayList;
    }

    @Override
    public void addDay(Day day) {
        dayDao.save(day);
    }

    @Override
    public void updateDay(Day day) {
        dayDao.saveAndFlush(day);
    }

    @Override
    public void removeDay(int id) {
        dayDao.deleteById(id);
    }

    @Override
    public Day getDayById(int id) {
        return dayDao.getOne(id);
    }
}
