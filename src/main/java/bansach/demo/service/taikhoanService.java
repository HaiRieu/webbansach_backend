package bansach.demo.service;

import bansach.demo.Repositority.khachhangRepositority;
import bansach.demo.model.Khachhang;
import bansach.demo.model.thongbao;
import bansach.demo.securiti.securitiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class taikhoanService {

    @Autowired
    private khachhangRepositority  khachhangRepositority ;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder ;

     public ResponseEntity<?>  dangkitaikhoankh(Khachhang khachhang) {
         if(khachhangRepositority.existsByTendangnhap(khachhang.getTendangnhap())) {
             return  ResponseEntity.badRequest().body(new thongbao("Tên đăng nhập đã tồn tại"));
         }
         if(khachhangRepositority.existsByEmail(khachhang.getEmail())) {
             return  ResponseEntity.badRequest().body(new thongbao("Email này đã tồn tại"));

         }
         String matkhaumahoa = bCryptPasswordEncoder.encode(khachhang.getMatkhau());
         khachhang.setMatkhau(matkhaumahoa);


         Khachhang khachhang1 = khachhangRepositority.save(khachhang) ;
         return ResponseEntity.ok().body(new thongbao("Đăng kí tài khoản thành công")) ;


     }


}
