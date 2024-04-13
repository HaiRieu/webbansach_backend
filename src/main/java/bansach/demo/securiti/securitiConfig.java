package bansach.demo.securiti;


import bansach.demo.service.userServive;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.EndpointConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@Configuration
public class securitiConfig {


    @Bean
    public BCryptPasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder() ;
    }

    @Bean
    @Autowired
    public DaoAuthenticationProvider daoAuthenticationProvider (userServive userServive) {
       DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider() ;
       daoAuthenticationProvider.setUserDetailsService(userServive);
       daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
       return daoAuthenticationProvider ;



    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
           http.authorizeHttpRequests(
                   configu -> configu.
                           requestMatchers(  HttpMethod.GET , endpond.PUBLIC_GET_ENPOINS ).permitAll()
                           .requestMatchers(HttpMethod.POST , endpond.PUBLIC_POST_ENPOINS).permitAll()
                           .requestMatchers(HttpMethod.GET,endpond.ADMIN_GET_ENPOINS).hasAuthority("ADMIN")


                   ) ;
       http.cors(cors -> {
               cors.configurationSource(request -> {
                   CorsConfiguration configuration = new CorsConfiguration();
                   configuration.addAllowedOrigin(endpond.font_end_host);
                   configuration.setAllowedMethods(Arrays.asList("GET" , "POST" , "PUT" , "DELETE"));
                   configuration.addAllowedHeader("*");
                   return configuration ;
               });
           }) ;
           http.httpBasic(Customizer.withDefaults());
           http.csrf(cfst -> cfst.disable());
        return http.build() ;
    }



}
