package com.spring.boot.rocks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ContentController {

	@Autowired
	AppUserRepository appUserRepository;
	
	
    @RequestMapping("/")
    public String loadContent() {
        return "website";
    }

    @RequestMapping("/content1")
    public String getContent1() {
        return "content :: content1";
    }

    @RequestMapping("/content2")
    public String getContent2() {
        return "content :: content2";
    }
    
    @RequestMapping("/active")
    public String getactiveUsers(Model model) {
    	List<AppUser> users = appUserRepository.findByUserenabledTrue();
		model.addAttribute("users", users);
        return "users :: resultsList";
    }
    
    @RequestMapping("/inactive")
    public String getinactiveUsers(Model model) {
    	List<AppUser> users = appUserRepository.findByUserenabledFalse();
		model.addAttribute("users", users);
        return "users :: resultsList";
    }
    
    @RequestMapping("/all")
    public String getUsers(Model model) {
    	List<AppUser> users = appUserRepository.findAll();
		model.addAttribute("users", users);
        return "users :: resultsList";
    }
    
    @RequestMapping("/users")
    public String usersContent() {
        return "users";
    }
    
}