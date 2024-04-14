package bansach.demo.controller;


import bansach.demo.model.Khachhang;
import bansach.demo.securiti.Jwtrespon;
import bansach.demo.securiti.dangnhapRequest;
import bansach.demo.service.JwtService;
import bansach.demo.service.taikhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/taikhoan")
public class taikhoanController {

    @Autowired
    private taikhoanService taikhoanService ;

    @Autowired
    private AuthenticationManager authenticationManager ;


    @Autowired
    private JwtService jwtService ;




    @PostMapping("/dangki")
    public ResponseEntity<?> dangkikhachhang (@Validated @RequestBody Khachhang khachhang ) {
        ResponseEntity<?> responseEntity = taikhoanService.dangkitaikhoankh(khachhang);
        return  responseEntity ;

    }

    @GetMapping("/kichhoat")
    public ResponseEntity<?> kichhoattaikhoan (@RequestParam String email , @RequestParam String makichhoat ) {
         ResponseEntity<?> responseEntity = taikhoanService.kichhoattaikhoan(email , makichhoat) ;
         return  responseEntity ;
    }

    @PostMapping("/dangnhap")
    public ResponseEntity<?> dangnhap(@RequestBody dangnhapRequest dangnhapRequest)  {
  try {
      Authentication authentication=  authenticationManager.authenticate(new
              UsernamePasswordAuthenticationToken(dangnhapRequest.getTendangnhap(),dangnhapRequest.getMatkhau()));

      if(authentication.isAuthenticated()) {
      final  String jwt = jwtService.generateToken(dangnhapRequest.getTendangnhap());
      return  ResponseEntity.ok(new Jwtrespon(jwt) );
      }

  }catch (AuthenticationException e){
      return ResponseEntity.badRequest().body("Ten dang nhap hoac ma khau khong chinh xac");
  }
        return ResponseEntity.badRequest().body("xac thuc khong thanh cong");

    }





}
