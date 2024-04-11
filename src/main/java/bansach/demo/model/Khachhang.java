package bansach.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "khachhang")
public class Khachhang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makhachhang" , insertable = false, updatable = false)
    private int makhachhang ;

    @Column(name = "tenkhachhang")
    private String tenkhachhang ;

    @Column(name = "gioitinh")
    private String gioitinh ;

    @Column(name = "email")
    private String email ;

    @Column(name = "sdt")
    private String sdt ;

    @Column(name = "diachinhanhang")
    private String diachinhanhang ;

    @Column(name = "tendangnhap")
    private String tendangnhap ;

    @Column(name = "matkhau")
    private String matkhau ;

    @OneToMany(mappedBy = "khachhang" , cascade = {CascadeType.PERSIST , CascadeType.ALL ,
    })
    private List<Giohang> danhsachgh ;

    @OneToMany(mappedBy = "khachhang",fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<Sudanhgia> dssudanhgia ;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(
            name = "khachang_quyen",
            joinColumns = @JoinColumn(name = "makhachhang"),
            inverseJoinColumns = @JoinColumn(name = "maquyen")
    )
   private List<Quyen> quyen ;
}
