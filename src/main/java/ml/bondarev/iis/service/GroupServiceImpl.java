package ml.bondarev.iis.service;

import ml.bondarev.iis.dao.GroupDao;
import ml.bondarev.iis.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;


    @Override
    public List<Group> getListGroup() {
        return groupDao.findAll();
    }

    @Override
    public void addGroup(Group group) {
        groupDao.save(group);
    }

    @Override
    public void updateGroup(Group group) {
        groupDao.saveAndFlush(group);
    }

    @Override
    public Group getGroupById(int id) {
        return groupDao.getOne(id);
    }

    @Override
    public void removeGroup(int id) {
        groupDao.deleteById(id);
    }
}
