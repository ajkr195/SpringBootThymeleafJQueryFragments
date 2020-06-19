package com.spring.boot.rocks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.rocks.model.AppUser;
import com.spring.boot.rocks.repository.AppUserRepository;

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
        return "content/mycontent :: content1";
    }

    @RequestMapping("/content2")
    public String getContent2() {
        return "content/mycontent :: content2";
    }
    
    @RequestMapping("/active")
    public String getactiveUsers(Model model) {
    	List<AppUser> users = appUserRepository.findByUserenabledTrue();
		model.addAttribute("users", users);
        return "tables/usertable :: resultsList";
    }
    
    @RequestMapping("/inactive")
    public String getinactiveUsers(Model model) {
    	List<AppUser> users = appUserRepository.findByUserenabledFalse();
		model.addAttribute("users", users);
        return "tables/usertable :: resultsList";
    }
    
    @RequestMapping("/all")
    public String getUsers(Model model) {
    	List<AppUser> users = appUserRepository.findAll();
		model.addAttribute("users", users);
        return "tables/usertable :: resultsList";
    }
    
    @RequestMapping("/users")
    public String usersContent() {
        return "users";
    }
    
    @RequestMapping("/user/{id}")
    public String usersModalContent(@PathVariable("id") Long id, Model model) {
    	
    	Optional<AppUser> appUser = appUserRepository.findById(id);
    	model.addAttribute("user", appUser);
    	return "fragments/usermodal :: users";
    }
    
    
    @GetMapping("/findOne") 
	@ResponseBody
	public Optional<AppUser> findOne (Long id) {
		return appUserRepository.findById(id);
	}
    
    
}