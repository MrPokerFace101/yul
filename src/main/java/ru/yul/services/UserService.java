package ru.yul.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yul.models.User;
import ru.yul.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user.getId(), user.getName(), user.getDeviceId());
    }

    public User getUserByDeviceId(String deviceId) {
        return userRepository.findByDeviceId(deviceId);
    }
}
