package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import javax.validation.Valid;


@Controller
public class MainController {
    
    @Autowired
    private UserRepository userRepo;

    static String valueAttribute;

    @GetMapping("/register")
    public String showForm(Model model) {
        model = createPage(model);
        model.addAttribute("registerSearch", "Register");
        valueAttribute = "Register";
        return "register_form";
    }

    public String saveUser(@Valid User user, BindingResult result, Model model) {
        model.addAttribute("registerSearch", "Register");
        if(result.hasErrors()) {
            return "register_form";
        }
        
        userRepo.save(user);
        System.out.println(user);
        return "register_success";
    }
    
    @PostMapping("/registerMe")
    public String saveSearchDelete(@Valid User user, BindingResult result, Model model) {
        if(valueAttribute.equals("Search"))
            return search(user);
        else if(valueAttribute.equals("Register"))
            return saveUser(user, result, model);
        else
            return deleteAll(user, model);
    }

    public String search(User user) {
        Iterable<User> it = userRepo.findAll();
        for (User use : it) {
            if(use.getName().equalsIgnoreCase(user.getName())) {
                return "register_success";
            }
        }
        return "no_user_found";
    }

    @GetMapping("/register_success")
    public String getAllUsers(Model model) {
        
        model.addAttribute("user", userRepo.findAll(Sort.by(Sort.Direction.ASC, "name")));
        return "register_success";
    }

    @GetMapping("/delete")
    public String deletPage(User user, Model model) {
        model = createPage(model);
        model.addAttribute("registerSearch", "Delete");
        valueAttribute = "Delete";
        return "register_form";
    }
    public String deleteAll(User user, Model model) {
        Iterable<User> it = userRepo.findAll();
        boolean found = false;
        for (User use : it) {
            if(use.getName().equalsIgnoreCase(user.getName())) {
                found = true;
                userRepo.deleteById(use.getId());
            }
        }
        if(found)
            return getAllUsers(model);
        else
            return "no_user_found";
    }

    @GetMapping("/search")
    public String viewSelected(Model model) {
        model = createPage(model);
        model.addAttribute("registerSearch", "Search");
        valueAttribute = "Search";
        return "register_form";
    }

    public Model createPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        List<String> professions = new ArrayList<>();
        professions.add("Developer");
        professions.add("Tester");
        professions.add("architect");

        model.addAttribute("listProfession", professions);
        return model;
    }
    
}
