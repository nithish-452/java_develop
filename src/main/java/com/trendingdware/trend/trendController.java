package com.trendingdware.trend;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class trendController {
	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	@Autowired
	private jpaRepostiory userRepository;
	@PostMapping("/login")
    public String login(registerPojo test) {
	    Optional<registerPojo> user =
	    		userRepository.findByUsername(test.getUsername());
	    if (user.isEmpty()) {
	        return "not";
	    }
	    registerPojo dbUser = user.get();
	    
	    if (dbUser.getUsername().equals(test.getUsername()) && dbUser.getPassword().equals(test.getPassword())) {
	    	return "loginsuccess";
	    }
    	    return "passwordwrong";
    }
	
    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerPage(registerPojo test) {
        userRepository.save(test);
        return "success";
    }
}