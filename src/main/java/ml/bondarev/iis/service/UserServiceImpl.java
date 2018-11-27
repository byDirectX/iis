package ml.bondarev.iis.service;

import ml.bondarev.iis.dao.UserDao;
import ml.bondarev.iis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getListUser() {
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public void removeUser(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getOne(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }
}