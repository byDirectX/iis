package com.bondarev.iis.service;

import com.bondarev.iis.dao.DayDao;
import com.bondarev.iis.model.Day;
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
