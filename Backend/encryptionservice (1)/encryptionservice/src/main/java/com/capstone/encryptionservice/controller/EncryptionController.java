package com.capstone.encryptionservice.controller;

import com.capstone.encryptionservice.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encryption")
public class EncryptionController {

    @Autowired
    private EncryptionService encryptionService;

    @PostMapping("/encrypt")
    public ResponseEntity<String> encrypt(@RequestBody String text) {
        try {
            String encryptedText = encryptionService.encrypt(text);
            return ResponseEntity.ok(encryptedText);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error occurred during encryption: " + e.getMessage());
        }
    }

    @PostMapping("/decrypt")
    public ResponseEntity<String> decrypt(@RequestBody String encryptedText) {
        try {
            String decryptedText = encryptionService.decrypt(encryptedText);
            return ResponseEntity.ok(decryptedText);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error occurred during decryption: " + e.getMessage());
        }
    }
}
