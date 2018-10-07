package com.bondarev.shedulesubsystem.dao;

import com.bondarev.shedulesubsystem.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayDao extends JpaRepository<Day, Integer> {
}
