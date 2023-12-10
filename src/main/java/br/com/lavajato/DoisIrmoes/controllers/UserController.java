package br.com.lavajato.DoisIrmoes.controllers;

import br.com.lavajato.DoisIrmoes.controllers.request.UserResponse;
import br.com.lavajato.DoisIrmoes.controllers.request.UserRequest;
import br.com.lavajato.DoisIrmoes.domain.User;
import br.com.lavajato.DoisIrmoes.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserResponse> saveUser(@RequestBody @Valid UserRequest request) {
        User user = userService.saveUser(request);
        UserResponse response = new UserResponse(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody @Valid UserRequest request) {
        User user = userService.updateUser(userId, request);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Integer userId) {
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
