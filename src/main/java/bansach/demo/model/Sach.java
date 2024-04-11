package bansach.demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "sach")
public class Sach {
    @Id
    @Column(name = "masach")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int masach ;

    @Column(name = "tensach")
    private String tensach ;

    @Column(name = "tentacgia")
    private String tentacgia ;

    @Column(name = "isbn")
    private String ISBN ;

    @Column(name = "mota")
    private String mota ;

    @Column(name = "gianiemyet")
    private double gianiemyet ;

    @Column(name = "giaban")
    private double giaban ;

    @Column(name = "soluong")
    private int solong ;

    @ManyToMany(fetch = FetchType.LAZY ,
    cascade = {CascadeType.PERSIST , CascadeType.MERGE ,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(
            name = "sach_theloai",
            joinColumns = @JoinColumn(name = "masach"),
            inverseJoinColumns = @JoinColumn(name = "matheloai")
    )
    private List<Theloai> danhsachtheloai ;


    @OneToMany(mappedBy = "sach" , cascade = {CascadeType.PERSIST , CascadeType.ALL ,
    })
    private List<Hinhanh> danhsachhinhanh ;

    @OneToMany(mappedBy = "sach" , cascade = {CascadeType.PERSIST , CascadeType.ALL ,
    })
    private List<Sudanhgia> danhsachsudanhgia ;

    @OneToMany(mappedBy = "sach" ,
            cascade = {CascadeType.PERSIST , CascadeType.MERGE ,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<Chitietdonhang> danhsachctdh ;

    @Column(name = "trungbinhxephang")
    private double trungbinhxephang ;



}
