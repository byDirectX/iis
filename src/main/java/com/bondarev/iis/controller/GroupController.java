package com.bondarev.iis.controller;

import com.bondarev.iis.model.Group;
import com.bondarev.iis.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GroupController {

    private static final Logger log = LoggerFactory.getLogger(GroupController.class);

    @Autowired
    private GroupService groupService;


    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public ModelAndView mainGroup(ModelAndView mav) {
        mav.addObject("listGroup", groupService.getListGroup());
        mav.addObject("group", new Group());

        log.info("Group issued sucessfully");

        mav.setViewName("group");
        return mav;
    }

    @RequestMapping(value = {"/group"}, method = RequestMethod.POST)
    public String addGroup(@ModelAttribute Group group) {
        if (group.getId() == 0) {
            groupService.addGroup(group);
            log.info("Group added sucessfully");
        } else {
            groupService.updateGroup(group);
            log.info("Group update sucessfully");
        }

        return "redirect:/group";
    }

    @RequestMapping(value = "/group/remove", method = RequestMethod.GET)
    public String removeGroup(@RequestParam("id") int id) {
        groupService.removeGroup(id);

        log.info("Group remove sucessfully");

        return "redirect:/group";
    }

    @RequestMapping(value = "/group/edit", method = RequestMethod.GET)
    public ModelAndView editGroup(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("group", groupService.getGroupById(id));
        mav.addObject("listGroup", groupService.getListGroup());

        log.info("Group for edit issued sucessfully");

        mav.setViewName("group");
        return mav;
    }

}
