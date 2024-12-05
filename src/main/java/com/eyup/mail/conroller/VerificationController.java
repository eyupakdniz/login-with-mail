package com.eyup.mail.conroller;


import com.eyup.mail.service.VerificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {

    private VerificationService verificationService;

    public VerificationController(VerificationService verificationService){
        this.verificationService = verificationService;
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam("token") String token) {
        System.out.println(token);
        boolean isVerified = verificationService.verifyUser(token);

        if (!isVerified) {
            return ResponseEntity.badRequest().body("Expired or invalid token!");
        }

        return ResponseEntity.ok("User successfully verified!");
    }

}

