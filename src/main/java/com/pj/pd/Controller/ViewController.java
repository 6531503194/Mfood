package com.pj.pd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pj.pd.Entity.Canteen;
import com.pj.pd.Entity.User;
import com.pj.pd.Repository.UserRepository;
import com.pj.pd.Service.CanteenService;
    
@Controller
public class ViewController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    private CanteenService canteenService;

    @GetMapping("/profile")
    public String profile( Model model , @RequestParam User user){
        
        model.addAttribute("name" , user.getUsername());
        model.addAttribute("email" , user.getEmail() );

        return "user-profile";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("===================   1  Hi in get(login) ==============");
        return "custom-login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam("email") String email, 
            @RequestParam("password") String password,
            Model model
            ) {
    
        System.out.println("hi========== before find user==================================");
        User user = userRepo.findByEmail(email);
        
        if (user != null) {
            System.out.println("Found user: " + user.getUsername());
         
            model.addAttribute("name", user.getUsername()); // Add the username to the model
            model.addAttribute("email", user.getEmail());
            return "user-profile";
        } else {
            System.out.println("No user found with email: " + email);
            return "error";
        }

    }

    
    @GetMapping("/signup")
    public String signup(){
        System.out.println("===================   2  Hi in get(signup) ==============");

        return "signup";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam("username") String username, 
            @RequestParam("email") String email, 
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword) {
        System.out.println("hi================  Confirm =========================");
        if(!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match");
            return "home";
        }
        System.out.println("hi========= exist===================================");

        if (userRepo.findByUsername(username) != null || userRepo.findByEmail(email) != null) {
            System.out.println("User already exists");
            return "custom-login";
        }

        System.out.println("hi========== before save ==================================");

       
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password); 
        user.setProvider(User.AuthProvider.LOCAL);
        userRepo.save(user);
        System.out.println("hi==============after save==============================");

        System.out.println("User registered: " + user.getEmail());

        ModelAndView modelAndView = new ModelAndView("user-profile");
        modelAndView.addObject("user", user);
        return "home";

    }


    

}
