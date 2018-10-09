package com.bondarev.iis.dao;

import com.bondarev.iis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {

    @Query("select usr from User usr where usr.name =:name")
    public User getUserByName(@Param("name") String name);
}
