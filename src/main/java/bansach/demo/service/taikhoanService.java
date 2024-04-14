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

import java.util.Random;

@Service
public class taikhoanService {


    private khachhangRepositority  khachhangRepositority ;

    private BCryptPasswordEncoder bCryptPasswordEncoder ;

    private emailService emailService ;

    @Autowired
    public taikhoanService(bansach.demo.Repositority.khachhangRepositority khachhangRepositority, BCryptPasswordEncoder bCryptPasswordEncoder, bansach.demo.service.emailService emailService) {
        this.khachhangRepositority = khachhangRepositority;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.emailService = emailService;
    }

    public ResponseEntity<?>  dangkitaikhoankh(Khachhang khachhang) {
         if(khachhangRepositority.existsByTendangnhap(khachhang.getTendangnhap())) {
             return  ResponseEntity.badRequest().body(new thongbao("Tên đăng nhập đã tồn tại"));
         }
         if(khachhangRepositority.existsByEmail(khachhang.getEmail())) {
             return  ResponseEntity.badRequest().body(new thongbao("Email này đã tồn tại"));

         }
         String matkhaumahoa = bCryptPasswordEncoder.encode(khachhang.getMatkhau());
         khachhang.setMatkhau(matkhaumahoa);

         khachhang.setMakichhoat(taomakichhoat());
         khachhang.setDakichhoat(false);

         Khachhang khachhang1 = khachhangRepositority.save(khachhang) ;

         guiemail(khachhang.getEmail() , khachhang.getMakichhoat());
        return ResponseEntity.ok().body(new thongbao("Đăng kí tài khoản thành công")) ;
     }

     private String taomakichhoat() {
         Random random = new Random() ;
         int makichhoatso = random.nextInt(100000) + 1 ;
         String makichhoat = Integer.valueOf(makichhoatso).toString();
         return makichhoat ;
     }
     private void guiemail (String email , String makichhoat) {
        String tieude = "Kích Hoạt Tài Khoản Của Bạn Tại WebBanSach";
        String url = "http://localhost:3000/taikhoan/kichhoat/"+email+"/"+makichhoat ;
        String noidung = "Vui Lòng Sử Dụng Mã Sau Để Kích Hoạt Cho Tài Khoản "
                + email +  " <html> <body>  </br> " +
                "<h1> " + makichhoat + "</h1> </body> </html>" ;
             noidung+= "</br> Click Vào Đường Dãn Đẻ Kích Hoạt: " + "</br> <a href=" +url+ " >     "+ url +"</a>";


          emailService.senMaseger ("dhai181204@gmail.com",email , tieude , noidung);

     }

     public ResponseEntity<?> kichhoattaikhoan (String email , String makichhoat) {

         Khachhang khachhang = khachhangRepositority.findByEmail(email);
         if (khachhang == null) {
             return ResponseEntity.badRequest().body(new thongbao(" khach hang k ton tai"));

         }
         if (khachhang.isDakichhoat()) {
             return ResponseEntity.badRequest().body(new thongbao(" tai khoan da dc kich hoat "));
         }
         if (makichhoat.equals(khachhang.getMakichhoat())) {
             khachhang.setDakichhoat(true);
             khachhangRepositority.save(khachhang);
             return ResponseEntity.badRequest().body(new thongbao(" tai khoan kich hoat thanh cong  "));
         }else {
             return ResponseEntity.badRequest().body(new thongbao(" ma kich hoat khong chinh xac "));
         }
     }

}
