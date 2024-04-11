package bansach.demo.service;

import bansach.demo.Repositority.khachhangRepositority;
import bansach.demo.Repositority.quyenRepositority;
import bansach.demo.model.Khachhang;
import bansach.demo.model.Quyen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;


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
        Khachhang khachhang = khachhangRepositority.findByTendangnhap(username) ;
        if(khachhang == null) {
         throw  new UsernameNotFoundException("tai khoan nay da ton tai") ;


        }


        return new User(khachhang.getTendangnhap(), khachhang.getMatkhau() ,grantedAuthorities(khachhang.getQuyen()));

    }

    private Collection<? extends GrantedAuthority > grantedAuthorities (Collection<Quyen> quyens) {
            return quyens.stream().map(quyen -> new SimpleGrantedAuthority(quyen.getTenquyen())).collect(Collectors.toList());

    }

}
