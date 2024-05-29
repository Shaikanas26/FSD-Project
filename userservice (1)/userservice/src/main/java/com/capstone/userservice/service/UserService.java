package com.capstone.userservice.service;

import com.capstone.userservice.client.EncryptionFeignClient;
import com.capstone.userservice.model.User;
import com.capstone.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionFeignClient encryptionFeignClient;

    public void registerUser(String username, String email, String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        String encryptedPassword = encryptionFeignClient.encrypt(password);
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null || !encryptionFeignClient.decrypt(user.getPassword()).equals(password)) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        return user;
    }
}
