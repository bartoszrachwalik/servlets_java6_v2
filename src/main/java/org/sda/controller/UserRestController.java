package org.sda.controller;

import org.sda.domain.User;
import org.sda.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping(value = "/findusers", method = RequestMethod.GET)
    public List<User> findUsers(){
        return userRepository.findAll();
    }
}
