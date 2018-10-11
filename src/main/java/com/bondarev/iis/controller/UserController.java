package com.bondarev.iis.controller;

import com.bondarev.iis.model.Role;
import com.bondarev.iis.model.User;
import com.bondarev.iis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user, ModelAndView mav) {
        User tempUser = userService.getUserByName(user.getName());

        if (tempUser != null) {
            mav.addObject("message", "Пользователь с таким логином существует");
            mav.setViewName("registration");

            log.info("Create user sucessfully");

            return mav;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.addUser(user);

        mav.setViewName("redirect:/login");
        return mav;
    }
}
