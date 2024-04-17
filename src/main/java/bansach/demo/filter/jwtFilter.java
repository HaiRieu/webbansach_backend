package bansach.demo.filter;

import bansach.demo.service.JwtService;
import bansach.demo.service.taikhoanService;
import bansach.demo.service.userServive;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class jwtFilter  extends OncePerRequestFilter {

    private JwtService jwtService ;
    private userServive taikhoanService ;


    @Autowired
    public jwtFilter(JwtService jwtService, userServive taikhoanService) {
        this.jwtService = jwtService;
        this.taikhoanService = taikhoanService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

       String authuthenr = request.getHeader("Authorization");
       String token = null ;
       String tendangnhap = null ;
       if(authuthenr != null && authuthenr.startsWith("Bearer ") ) {
          token = authuthenr.substring(7);
          tendangnhap = jwtService.extaName(token);
       }
       if(tendangnhap != null && SecurityContextHolder.getContext().getAuthentication() == null) {
           UserDetails userDetails = taikhoanService.loadUserByUsername(tendangnhap) ;
           if(jwtService.vailudattoken(token,userDetails)) {
               UsernamePasswordAuthenticationToken token1 = new UsernamePasswordAuthenticationToken(userDetails , null , userDetails.getAuthorities());
               token1.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
              SecurityContextHolder.getContext().setAuthentication(token1);

           }
       }
       filterChain.doFilter(request , response);

    }
}
