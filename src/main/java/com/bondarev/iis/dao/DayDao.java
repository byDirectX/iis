package com.bondarev.iis.dao;

import com.bondarev.iis.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayDao extends JpaRepository<Day, Integer> {
}
