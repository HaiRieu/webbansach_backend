package bansach.demo.securiti;


import bansach.demo.service.userServive;
import jakarta.servlet.http.HttpSession;
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
                   configu -> configu.requestMatchers(
                           HttpMethod.GET , "/sach" ).permitAll()
                          .requestMatchers(HttpMethod.GET,"/sach/**").permitAll()
                          .requestMatchers(HttpMethod.GET , "/khachhang" ).hasAuthority("ADMIN")
                           .requestMatchers(HttpMethod.POST , "/taikhoan/dangki" ).hasAuthority("ADMIN")

                   ) ;
           http.httpBasic(Customizer.withDefaults());
           http.csrf(cfst -> cfst.disable());
        return http.build() ;
    }



}
