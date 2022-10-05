package com.example.inventorycontrol.api.controller;

import com.example.inventorycontrol.api.dto.UserCreateDTO;
import com.example.inventorycontrol.api.dto.UserResponseDTO;
import com.example.inventorycontrol.api.model.UserModel;
import com.example.inventorycontrol.api.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/inventory/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserCreateDTO userCreateDTO) {
        if(userService.existsByUsername(userCreateDTO.getUsername())) {
            JSONObject response = new JSONObject();
            response.put("message", "User already exists, try again.");

            return ResponseEntity.status(HttpStatus.CONFLICT).body(response.toString());
        }

        if(userService.existsByMail(userCreateDTO.getMail())) {
            JSONObject response = new JSONObject();
            response.put("message", "User already exists, try again.");

            return ResponseEntity.status(HttpStatus.CONFLICT).body(response.toString());
        }

        UserModel userModel = new UserModel();

        BeanUtils.copyProperties(userCreateDTO, userModel);

        String passwordEncode = new BCryptPasswordEncoder().encode(userCreateDTO.getPassword());

        userModel.setPassword(passwordEncode);

        userModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        userModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        UserModel saveUser = userService.createUser(userModel);

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        BeanUtils.copyProperties(saveUser, userResponseDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }
}
