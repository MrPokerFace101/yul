package ru.yul.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yul.models.User;
import ru.yul.services.UserService;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> saveUser(String deviceId) {
        log.debug("saveUser(); deviceId={}", deviceId);
        return ResponseEntity.ok(userService.saveUser(User.builder().deviceId(deviceId).build()));
    }

    @GetMapping("/api/users/{deviceId}")
    public ResponseEntity<User> getUser(@PathVariable String deviceId) {
        log.debug("getUser(); deviceId={}", deviceId);
        User user = userService.getUserByDeviceId(deviceId);
        if (user == null) {
            log.error("getUser() 404 not found; deviceId={}", deviceId);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }
}
