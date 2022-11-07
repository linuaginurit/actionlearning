package com.agungfAl.actionlearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.agungfAl.actionlearning.service.UserService;

@Configuration
public class SecurityConfig {
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    // http.httpBasic();
    http.csrf().disable();
    http.authorizeRequests(c->c
            .antMatchers(HttpMethod.POST,"/users").permitAll()
            .antMatchers(HttpMethod.GET,"/users").permitAll()
            // .anyRequest().permitAll()
            .anyRequest().authenticated()
            );
    return http.build();
}


// @Bean
// SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//     return http.authorizeRequests(c->c
//             .antMatchers("/","/error","/webjars/**").permitAll()
//             .antMatchers(HttpMethod.POST,"/users").hasRole("ADMIN")
//             .anyRequest().authenticated()
//             )
//             .build();
// }

@Bean
AuthenticationManager customAuthenticationManager(UserService service,PasswordEncoder encoder){
    return authentication->{
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        // service.loadUserByUsername(username);
        if(encoder.matches(password,service.loadUserByUsername(username).getPassword())){
            return authentication;
        }
        throw new RuntimeException("Authentication failed");
    
    };
    
}


}
