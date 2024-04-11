package bansach.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hinhanh")
public class Hinhanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mahinhanh")
    private int mahinhanh ;

    @Column(name = "tenhinhanh")
    private String tenhinhanh ;

    @Column(name = "icon")
    private String icon ;

    @Column(name = "url")
    private String url ;

    @Column(name = "dulieuanh")
    private String dulieuanh ;

    @ManyToOne(cascade = {
            CascadeType.PERSIST , CascadeType.MERGE,
            CascadeType.DETACH , CascadeType.REFRESH
    })
    @JoinColumn(name = "masach")
    private Sach sach ;
}
