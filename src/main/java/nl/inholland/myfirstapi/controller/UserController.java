package nl.inholland.myfirstapi.controller;

import lombok.extern.java.Log;
import nl.inholland.myfirstapi.model.LoginDTO;
import nl.inholland.myfirstapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@Log
@RequestMapping(value="/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value="add")
    public ResponseEntity<String> addUser(@RequestBody LoginDTO loginDTO){
        String token = userService.add(loginDTO.getUsername(), loginDTO.getPassword(), new ArrayList<>());
        return ResponseEntity.ok(token);
    }

    @PostMapping(value="login")
    public String login(@RequestBody LoginDTO loginDTO){
        log.info(loginDTO.toString());
        return userService.login(loginDTO.getUsername(),loginDTO.getPassword());
    }
}
