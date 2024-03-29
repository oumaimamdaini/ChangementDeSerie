package com.spring.changementserie.auth;

import com.spring.changementserie.Models.Profil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private Profil profil;

    public String getAccessToken() {
        return token;
    }
}
