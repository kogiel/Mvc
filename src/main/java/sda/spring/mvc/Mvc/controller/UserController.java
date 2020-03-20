package sda.spring.mvc.Mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.spring.mvc.Mvc.model.dto.UserDto;
import sda.spring.mvc.Mvc.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/adduser")
    public ModelAndView addUser() {
        return new ModelAndView("adduser",
                "userToInsert", new UserDto());
    }

    @PostMapping(value = "/adduser")
    public String addNewUser(@ModelAttribute UserDto userDto) {
        userService.addUser(userDto);
        return "index";
    }

    @GetMapping(value="/users")
    public ModelAndView showUsers() {
        return new ModelAndView(
                        "userlist",
                        "allUsers",
                        userService.getAllUsers());
    }
    @PostMapping(value = "/deleteuser")
    public String deleteUser(@ModelAttribute UserDto userDto){
        userService.delete(userDto.getLogin());
        return "redirect:userlist";
    }
}
