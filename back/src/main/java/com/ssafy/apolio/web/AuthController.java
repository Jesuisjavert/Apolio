package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.account.Account;
import com.ssafy.apolio.domain.account.AuthProvider;
import com.ssafy.apolio.domain.account.Role;
import com.ssafy.apolio.exception.BadRequestException;
import com.ssafy.apolio.payload.ApiResponse;
import com.ssafy.apolio.payload.AuthResponse;
import com.ssafy.apolio.payload.LoginRequest;
import com.ssafy.apolio.payload.SignUpRequest;
import com.ssafy.apolio.repository.UserRepository;
import com.ssafy.apolio.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

//import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }
        // Creating user's account
        Account account = new Account();
        account.setUsername(signUpRequest.getName());
        account.setEmail(signUpRequest.getEmail());
        account.setPassword(signUpRequest.getPassword());
        account.setRole(Role.MEMBER);
        account.setProvider(AuthProvider.local);

        account.setPassword(passwordEncoder.encode(account.getPassword()));

        Account result = userRepository.save(account);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully@"));
    }

}
