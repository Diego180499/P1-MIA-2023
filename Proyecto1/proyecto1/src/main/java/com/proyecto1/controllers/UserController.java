package com.proyecto1.controllers;

import com.proyecto1.dto.userDTO.request.NewUserDTO;
import com.proyecto1.dto.userDTO.response.UserCreatedDTO;
import com.proyecto1.dto.userDTO.response.UserDTO;
import com.proyecto1.dto.userDTO.response.UserReportDTO;
import com.proyecto1.exception.MarketException;
import com.proyecto1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/add")
    public ResponseEntity<UserCreatedDTO> createUser(@RequestBody NewUserDTO newUser){
        try {
            return new ResponseEntity<>(userService.createUser(newUser), HttpStatus.CREATED);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/find/{user}")
    public ResponseEntity<UserDTO> getByUser(@PathVariable String user){
        try {
            return new ResponseEntity<>(userService.getById(user),HttpStatus.OK);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/getUsers")
    public ResponseEntity<ArrayList<UserReportDTO>> getUsers(){
       return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }

}
