package com.crud.crudproject.controller;

import com.crud.crudproject.model.User;
import com.crud.crudproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/showUsers")
    public String findUsers(Model model){
        var users = (List<User>) userService.findAll();
        model.addAttribute("users", users);
        return "show-user";

    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.save(user);
        return "redirect:/showUsers";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.get(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);

        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userService.save(user);

        return "redirect:/showUsers";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.get(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.delete(user);

        return "redirect:/showUsers";
    }

//    @RequestMapping("/showUsers")
//    public ModelAndView home() {
//        List<User> users = userService.findAll();
//        ModelAndView mav = new ModelAndView("showUsers");
//        mav.addObject("users", users);
//        return mav;
//    }
}
