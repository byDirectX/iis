package ml.bondarev.iis.controller;

import ml.bondarev.iis.model.Group;
import ml.bondarev.iis.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;


    @GetMapping(value = "/group")
    public ModelAndView getListGroup(ModelAndView mav) {
        mav.addObject("groupList", groupService.getListGroup());
        mav.addObject("group", new Group());

        mav.setViewName("group");
        return mav;
    }

    @PostMapping(value = "/group")
    public String addUpdateGroup(@ModelAttribute Group group) {
        if (group.getId() == 0) {
            groupService.addGroup(group);
        } else {
            groupService.updateGroup(group);
        }

        return "redirect:/group";
    }

    @GetMapping(value = "/group/edit")
    public ModelAndView getGroupById(@RequestParam int id, ModelAndView mav) {
        mav.addObject("groupList", groupService.getListGroup());
        mav.addObject("group", groupService.getGroupById(id));

        mav.setViewName("group");
        return mav;
    }

    @GetMapping(value = "/group/remove")
    public String removeGroup(@RequestParam int id) {
        groupService.removeGroup(id);

        return "redirect:/group";
    }
}
