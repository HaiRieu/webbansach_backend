package bansach.demo.service;

import bansach.demo.model.Khachhang;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface userServive extends UserDetailsService {

    public Khachhang findByKhachhangname( String tenkhachhang) ;


}
