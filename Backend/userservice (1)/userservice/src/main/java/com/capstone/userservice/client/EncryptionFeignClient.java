package com.capstone.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "encryption-service", url = "http://localhost:8082")
public interface EncryptionFeignClient {

    @PostMapping("/encryption/encrypt")
    String encrypt(@RequestBody String text);

    @PostMapping("/encryption/decrypt")
    String decrypt(@RequestBody String encryptedText);
}
