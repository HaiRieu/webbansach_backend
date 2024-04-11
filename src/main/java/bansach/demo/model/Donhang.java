package bansach.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "donhang")
public class Donhang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "madonhang")
    private int madonhang ;

    @Column(name = "tensach")
    private String tensach ;

    @Column(name = "ngaytao")
    private Date ngaytao ;

    @Column(name = "diachinhanhang")
    private String diachinhanhang ;

    @Column(name = "tongtien")
    private double tongtien ;

    @OneToMany(mappedBy = "donhang",
            fetch = FetchType.LAZY , cascade = CascadeType.ALL
    )
    private List<Chitietdonhang> dschitietdonhang ;

    @Column(name = "trangthaithanhtoan")
    private String trangthaithanhtoan ;

    @Column(name = "trangthaigiaohang")
    private String trangthaigiaohang ;

    @ManyToOne(cascade = {
            CascadeType.PERSIST , CascadeType.MERGE,
            CascadeType.DETACH , CascadeType.REFRESH
    })
    @JoinColumn(name = "makhachhang")
    private Khachhang khachhang ;

    @ManyToOne(cascade = {
            CascadeType.PERSIST , CascadeType.MERGE,
            CascadeType.DETACH , CascadeType.REFRESH
    })
   @JoinColumn(name = "mahinhthucthanhtoan")
    private Hinhthucthanhtoan hinhthucthanhtoan ;

    @ManyToOne(cascade = {
            CascadeType.PERSIST , CascadeType.MERGE,
            CascadeType.DETACH , CascadeType.REFRESH
    })
    @JoinColumn(name = "mahinhthucgiaohang")
    private Hinhthucgiaohang hinhthucgiaohang ;

}
