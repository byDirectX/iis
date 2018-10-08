package com.bondarev.iis.controller;

import com.bondarev.iis.service.GroupService;
import com.bondarev.iis.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;


    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public ModelAndView mainGroup(ModelAndView mav) {
        mav.addObject("listGroup", groupService.getListGroup());
        mav.addObject("group", new Group());

        mav.setViewName("group");
        return mav;
    }

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public String addGroup(@ModelAttribute Group group) {
        if (group.getId() == 0) {
            groupService.addGroup(group);
        } else {
            groupService.updateGroup(group);
        }

        return "redirect:/group";
    }

    @RequestMapping(value = "/group/remove", method = RequestMethod.GET)
    public String removeGroup(@RequestParam("id") int id) {
        groupService.removeGroup(id);

        return "redirect:/group";
    }

    @RequestMapping(value = "/group/edit", method = RequestMethod.GET)
    public ModelAndView editGroup(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("group", groupService.getGroupById(id));
        mav.addObject("listGroup", groupService.getListGroup());

        mav.setViewName("group");
        return mav;
    }

}
