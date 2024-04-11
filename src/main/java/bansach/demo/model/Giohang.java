package bansach.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "giohang")
public class Giohang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "magiohang")
    private int magiohang ;

    @Column(name = "ngaytao")
    private Date ngaytao ;

    @Column(name = "tongtien")
    private double tongtien ;

    @ManyToOne(cascade = {
            CascadeType.PERSIST , CascadeType.MERGE,
            CascadeType.DETACH , CascadeType.REFRESH
    })
    @JoinColumn(name = "makhachhang")
    private Khachhang khachhang ;
}
