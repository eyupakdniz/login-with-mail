package com.eyup.mail.service;

import com.eyup.mail.entity.User;
import com.eyup.mail.entity.VerificationToken;
import com.eyup.mail.repository.UserRepository;
import com.eyup.mail.repository.VerificationTokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final VerificationTokenRepository tokenRepository;
    private final EmailService emailService;

    public UserService(UserRepository userRepository,
                       VerificationTokenRepository tokenRepository,
                       EmailService emailService) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.emailService = emailService;
    }


    public void registerUser(User user) {
        user.setActive(false);
        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationToken.setExpiryDate(LocalDateTime.now().plusHours(24));
        tokenRepository.save(verificationToken);

        String verificationLink = "http://localhost:8080/verify?token=" + token;
        emailService.sendEmail(user.getEmail(), "Verify your account", "Link: " + verificationLink);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
