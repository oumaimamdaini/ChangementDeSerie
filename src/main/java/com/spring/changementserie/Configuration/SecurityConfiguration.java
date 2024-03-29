package com.spring.changementserie.Configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.spring.changementserie.Models.Permission.*;
import static com.spring.changementserie.Models.Profil.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(req ->
                    req.requestMatchers("/auth/**"/*,
                                    "/interface/**",
                                    "/famille/**",
                                    "/produit/**",
                                    "/checklist/**",
                                    "/changementserie/**",
                                    "/demandechangement/**",
                                    "/testeur/**",
                                    "/rapport/**",
                                    "/user/**"*/

                            )
                            .permitAll()

                            .requestMatchers("/api/v1/management/**").hasAnyRole(ADMIN.name(),technicienPrev.name())
                            .requestMatchers(GET,"/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(),technicienPrev_READ.name())
                            .requestMatchers(POST,"/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name())
                            .requestMatchers(PUT,"/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name())
                            .requestMatchers(DELETE,"/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name())

                            .requestMatchers("/user/**").hasAnyRole(ADMIN.name())
                            .requestMatchers(GET,"/user/**").hasAnyAuthority(ADMIN_READ.name())
                            .requestMatchers(POST,"/user/**").hasAnyAuthority(ADMIN_CREATE.name())
                            .requestMatchers(PUT,"/user/**").hasAnyAuthority(ADMIN_UPDATE.name())
                            .requestMatchers(DELETE,"/user/**").hasAnyAuthority(ADMIN_DELETE.name())

                            /*.requestMatchers("/checklist/**").hasAnyRole(ADMIN.name(),technicienPrev.name(),technicienPrep.name(),technicienCur.name(),responsableMéthode.name(),chefSecteurCur.name())
                            .requestMatchers(GET,"/checklist/**").hasAnyAuthority(ADMIN_READ.name(),technicienPrev_READ.name(),technicienCur_READ.name(),technicienPrep_READ.name(),responsableMéthode_READ.name(),chefSecteurCur_READ.name())
                            .requestMatchers(POST,"/checklist/**").hasAnyAuthority(ADMIN_CREATE.name(),technicienPrev_CREATE.name(),technicienCur_CREATE.name(),technicienPrep_CREATE.name(),responsableMéthode_CREATE.name(),chefSecteurCur_CREATE.name())
                            .requestMatchers(PUT,"/checklist/**").hasAnyAuthority(ADMIN_UPDATE.name())
                            .requestMatchers(DELETE,"/checklist/**").hasAnyAuthority(ADMIN_DELETE.name())*/

                           /* .requestMatchers("/interface/**").hasAnyRole(ADMIN.name(),technicienPrev.name(),technicienPrep.name(),technicienCur.name(),responsableMéthode.name(),chefSecteurCur.name())
                            .requestMatchers(GET,"/interface/**").hasAnyAuthority(ADMIN_READ.name(),technicienPrev_READ.name(),technicienCur_READ.name(),technicienPrep_READ.name(),responsableMéthode_READ.name(),chefSecteurCur_READ.name())
                            .requestMatchers(POST,"/interface/**").hasAnyAuthority(ADMIN_CREATE.name(),technicienPrev_CREATE.name(),technicienCur_CREATE.name(),technicienPrep_CREATE.name(),responsableMéthode_CREATE.name(),chefSecteurCur_CREATE.name())
                            .requestMatchers(PUT,"/interface/**").hasAnyAuthority(ADMIN_UPDATE.name())
                            .requestMatchers(DELETE,"/interface/**").hasAnyAuthority(ADMIN_DELETE.name())*/

                            /*.requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())
                            .requestMatchers(GET,"/api/v1/admin/**").hasAuthority(ADMIN_READ.name())
                            .requestMatchers(POST,"/api/v1/admin/**").hasAuthority(ADMIN_CREATE.name())
                            .requestMatchers(PUT,"/api/v1/admin/**").hasAuthority(ADMIN_UPDATE.name())
                            .requestMatchers(DELETE,"/api/v1/admin/**").hasAuthority(ADMIN_DELETE.name())*/



                            .anyRequest()
                            .authenticated()

            )
            .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)


    ;
           return http.build();
    }

}