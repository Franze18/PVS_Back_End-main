package com.pvsbackend.pvs.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pvsbackend.pvs.Model.User;
import com.pvsbackend.pvs.NotFoundException.UserNotFoundException;
import com.pvsbackend.pvs.Repository.UserRepository;

@RestController
public class UserController {
    
    UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // GET ALL USERS
    // http://127.0.0.1:8080/uses
    @GetMapping("/users")
    public List<User> getuser(){
        return repo.findAll();
    }

    // GET ONE USER
    // http://127.0.0.1:8080/user/1
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new UserNotFoundException(id));
    }

    // CREATE ENDPOINTS
    // http://127.0.0.1:8080/user/new
    @PostMapping("/user/new")
    public String addUser(@RequestBody User newUser){
        repo.save(newUser);
        return "A new user is added. Yey!";
    }

    // UPDATE ENDPOINTS
    // http://127.0.0.1:8080/user/edit/1
    @PutMapping("/user/edit/{id}")
    public User updateUser(@PathVariable Long id,
    @RequestBody User newUser){
        return repo.findById(id)
        .map(user ->{
            user.setUserName(newUser.getUserName());
            user.setCourse(newUser.getCourse());
            user.setYear(newUser.getYear());
            return repo.save(user);
        }).orElseGet(()->{
            return repo.save(newUser);
        });
    }

    // DELETE ENDPOINTS
    // http://127.0.0.1:8080/user/delete/1
    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        repo.deleteById(id);
        return "A user is deleted!";
    }
}