package ml.bondarev.iis.restController;

import ml.bondarev.iis.model.Group;
import ml.bondarev.iis.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController
@RequestMapping(value = "/api")
public class RestGroupController {

    private static final Logger log = LoggerFactory.getLogger(RestGroupController.class);

    @Autowired
    private GroupService groupService;


    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public List<Group> getListGroup() {
        log.info("Get list group");
        return groupService.getListGroup();
    }

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public void addGroup(@ModelAttribute Group group) {
        if (group.getId() == 0) {
            groupService.addGroup(group);
            log.info("Group added successfully");
        } else {
            groupService.updateGroup(group);
            log.info("Group update successfully");
        }
    }

    @RequestMapping(value = "/group/{id}", method = RequestMethod.DELETE)
    public void removeGroup(@PathVariable("id") int id) {
        groupService.removeGroup(id);

        log.info("Group remove successfully");
    }

    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public Group getOneGroup(@PathVariable("id") int id) {
        log.info("Get one group by id: " + id);
        return groupService.getGroupById(id);
    }

}
