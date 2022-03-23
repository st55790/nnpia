package cs.upce.fei.todoapp.controller;

import cs.upce.fei.todoapp.dto.AddUserDto;
import cs.upce.fei.todoapp.entity.User;
import cs.upce.fei.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String showLoginForm(Model model){
        model.addAttribute("user", new AddUserDto());
        return "login";
    }

    @PostMapping("/user-login-process")
    public String userLoginProcess(AddUserDto addUserDto){
        User user = userRepository.findUserByUsernameAndPassword(addUserDto.getUsername(), addUserDto.getPassword());
        if(user != null){//user.getPassword().equals(addUserDto.getPassword()) && user.getUsername().equals(addUserDto.getUsername())
            Long id = user.getId();
            return "redirect:/todo-lists/" + id;
        }
        return "redirect:/";

    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new AddUserDto());
        return "register";
    }

    @PostMapping("/user-register-process")
    public String userRegisterProcess(AddUserDto addUserDto){
        User user = userRepository.findUserByName(addUserDto.getUsername());
        if(user != null){
            return "redirect:/register";
        }

        user = new User(addUserDto.getUsername(), addUserDto.getPassword(), addUserDto.getEmail());
        userRepository.save(user);

        return "redirect:/tasks";
    }
}
