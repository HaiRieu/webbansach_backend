package bansach.demo.controller;


import bansach.demo.model.Khachhang;
import bansach.demo.service.taikhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taikhoan")
public class taikhoanController {

    @Autowired
    private taikhoanService taikhoanService ;

    @PostMapping("/dangki")
    public ResponseEntity<?> dangkikhachhang (@Validated @RequestBody Khachhang khachhang ) {
        ResponseEntity<?> responseEntity = taikhoanService.dangkitaikhoankh(khachhang);
        return  responseEntity ;

    }

}
