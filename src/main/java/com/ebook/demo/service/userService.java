package com.ebook.demo.service;

import com.ebook.demo.base.users;
import com.ebook.demo.Repository.userRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class userService implements userServiceInter{
    @Autowired
    private userRepository userrepository;

    public users update(users user) {
        return userrepository.save(user);
    }

    public users findone(String id) {
        return userrepository.getOne(id);
    }
    public List<users> findAll(){
        return userrepository.findAll();
    }
    // 改为frozen
    public void delete(String id){
        userrepository.deleteById(id);
    }
}