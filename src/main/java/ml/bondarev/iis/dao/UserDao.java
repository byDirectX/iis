package ml.bondarev.iis.dao;

import ml.bondarev.iis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    @Query("select usr from User usr where usr.username =:name")
    public User getUserByName(@Param("name") String name);
}
