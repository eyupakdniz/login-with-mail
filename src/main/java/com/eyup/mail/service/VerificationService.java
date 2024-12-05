package com.eyup.mail.service;

import com.eyup.mail.entity.User;
import com.eyup.mail.entity.VerificationToken;
import com.eyup.mail.repository.VerificationTokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificationService {

    private final VerificationTokenRepository tokenRepository;
    private final UserService userService;

    public VerificationService(VerificationTokenRepository tokenRepository, UserService userService) {
        this.tokenRepository = tokenRepository;
        this.userService = userService;
    }

    public boolean verifyUser(String token) {
        VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken == null || verificationToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            return false;
        }

        User user = verificationToken.getUser();
        user.setActive(true);
        tokenRepository.delete(verificationToken);
        return true;
    }
}