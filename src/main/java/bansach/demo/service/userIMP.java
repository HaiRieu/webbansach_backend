package bansach.demo.service;

import bansach.demo.Repositority.khachhangRepositority;
import bansach.demo.Repositority.quyenRepositority;
import bansach.demo.model.Khachhang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class userIMP implements userServive{

    private khachhangRepositority khachhangRepositority ;
    private quyenRepositority  quyenRepositority ;

    @Autowired
    public userIMP(bansach.demo.Repositority.khachhangRepositority khachhangRepositority, bansach.demo.Repositority.quyenRepositority quyenRepositority) {
        this.khachhangRepositority = khachhangRepositority;
        this.quyenRepositority = quyenRepositority;
    }

    @Override
    public Khachhang findByKhachhangname(String tenkhachhang) {
        return khachhangRepositority.findByTendangnhap(tenkhachhang);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        
        return null;
    }
}
