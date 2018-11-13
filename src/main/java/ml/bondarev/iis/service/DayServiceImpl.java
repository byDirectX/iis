package ml.bondarev.iis.service;

import ml.bondarev.iis.dao.DayDao;
import ml.bondarev.iis.model.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private DayDao dayDao;


    @Override
    public List<Day> getListDay() {
        return dayDao.findAll();
    }
}
