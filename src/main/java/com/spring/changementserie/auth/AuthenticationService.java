package com.spring.changementserie.auth;

import com.spring.changementserie.Configuration.JwtService;
import com.spring.changementserie.Models.Profil;
import com.spring.changementserie.Models.Token;
import com.spring.changementserie.Models.TokenType;
import com.spring.changementserie.Repository.TokenRepository;
import com.spring.changementserie.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.spring.changementserie.Models.User;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .profil(request.getProfil())
                .build();
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }
    private void revokeAllUserToken(User user){
        var validUserTokens =tokenRepository.findAllValidTokenByUser(user.getId());
        if(validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(t ->{
        t.setExpired(true);
        t.setRevoked(true);
        } );
        tokenRepository.saveAll(validUserTokens);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user=repository.findByEmail(request.getEmail());

        var jwtToken = jwtService.generateToken(user);
        revokeAllUserToken(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .profil(user.getProfil())
                .build();
    }
}
