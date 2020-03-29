package ru.yul.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yul.models.User;
import ru.yul.services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> saveUser(String deviceId) {
        return ResponseEntity.ok(userService.saveUser(User.builder().deviceId(deviceId).build()));
    }

    @GetMapping("/api/users/{deviceId}")
    public ResponseEntity<User> getUser(@PathVariable String deviceId) {
        User user = userService.getUserByDeviceId(deviceId);
        return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
    }
}
