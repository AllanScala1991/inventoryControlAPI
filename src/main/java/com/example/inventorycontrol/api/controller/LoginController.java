package com.example.inventorycontrol.api.controller;

import com.example.inventorycontrol.api.dto.login.LoginDTO;
import com.example.inventorycontrol.api.model.UserModel;
import com.example.inventorycontrol.api.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Base64;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/inventory/api/login")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDTO loginDTO) {
        Optional<UserModel> getUserByUsername = userService.findUserByUsername(loginDTO.getUsername());

        if(!getUserByUsername.isPresent()) {
            JSONObject response = new JSONObject();
            response.put("message", "Username or Password incorrect, try again.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response.toString());
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if(!encoder.matches(loginDTO.getPassword(), getUserByUsername.get().getPassword())) {
            JSONObject response = new JSONObject();
            response.put("message", "Username or Password incorrect, try again.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response.toString());
        }

        String authorization = Base64.getEncoder().encodeToString((loginDTO.getUsername() + ":" + loginDTO.getPassword()).getBytes());

        JSONObject response = new JSONObject();
        response.put("token", authorization);

        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }
}
