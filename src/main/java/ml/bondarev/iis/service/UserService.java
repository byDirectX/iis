package ml.bondarev.iis.service;

import ml.bondarev.iis.model.User;

import java.util.List;


public interface UserService {
    public List<User> getListUser();

    public void addUser(User user);

    public void removeUser(int id);

    public void updateUser(User user);

    public User getUserById(int id);

    public User getUserByName(String name);
}