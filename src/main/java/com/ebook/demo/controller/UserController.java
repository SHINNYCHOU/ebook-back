package com.ebook.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.ebook.demo.base.users;
import com.ebook.demo.service.userService;

@CrossOrigin(origins = {"http://localhost:8081","null"},allowCredentials = "true")
@RestController
@RequestMapping(value="/user",method = {RequestMethod.GET, RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class UserController {
    @Autowired
    private userService userservice;

    @PutMapping(value = "/add/{name}")
    public users add(@PathVariable(value = "name") String name,
                            @RequestParam(value = "password") String password){
        users u=new users(name,password,0,1);
        return userservice.update(u);
    }
    @PutMapping(value = "/update/{name}")
    public users update(@PathVariable(value = "name") String name,@RequestParam(value = "state") String state){
        users u=userservice.findone(name);
        u.setState(Integer.parseInt(state));
        return userservice.update(u);
    }
    @GetMapping(value = "/get/{id}")
    public users getById(@PathVariable(value = "id") String id){
        return userservice.findone(id);
    }
    @GetMapping(value = "/get/userlist")
    public List<users> getAll(){
        return userservice.findAll();
    }
}
