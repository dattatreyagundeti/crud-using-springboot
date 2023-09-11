package com.exampleg.demo1.Controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleg.demo1.RestUser;

@RestController
@RequestMapping("/user")
public class index {

    Map<String, RestUser> allUsers = new HashMap<String, RestUser>();

    @GetMapping
    public Collection<RestUser> getMethod() {
        return allUsers.values();
    }
    // public Map<String, RestUser> getMethod() {
    //     return allUsers;
    // }
    
    @PostMapping
    public String postMethod(@RequestBody RestUser userdetails) {
        RestUser addUser = new RestUser();
        addUser.setUserId(userdetails.getUserId());
        addUser.setName(userdetails.getName());
        addUser.setEmail(userdetails.getEmail());
        allUsers.put(userdetails.getUserId(), addUser);
        return "user Added successfully";
    }

    @PutMapping(path = "/{userId}")
    public String put(@PathVariable String userId,@RequestBody RestUser userdetails){
        if (allUsers.containsKey(userId)){
            RestUser addUser = new RestUser();
            addUser.setUserId(userdetails.getUserId());
            addUser.setName(userdetails.getName());
            addUser.setEmail(userdetails.getEmail());
            allUsers.put(userId, addUser);
            return "edited success";
        }
        else{
            return "User not found";
        }
    }

    @DeleteMapping(path = "/{userId}")
    public String delete(@PathVariable String userId){
        if (allUsers.containsKey(userId)){
            allUsers.remove(userId);
            return "User Deleted Successfully";
        }
        else{
            return "User not found";
        }
    }
}
