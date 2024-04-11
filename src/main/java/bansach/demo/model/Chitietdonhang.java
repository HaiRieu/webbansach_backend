package bansach.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chitietdonhang")
public class Chitietdonhang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machitietdh")
    private int machitietdh ;

    @ManyToOne(cascade = {
            CascadeType.PERSIST , CascadeType.MERGE,
            CascadeType.DETACH , CascadeType.REFRESH
    })
    @JoinColumn(name = "masach")
    private Sach sach ;

    @Column(name = "soluong")
    private int soluong ;

    @Column(name = "giaban")
    private double giaban ;

    @ManyToOne(cascade = {
            CascadeType.PERSIST , CascadeType.MERGE,
            CascadeType.DETACH , CascadeType.REFRESH
    })
    @JoinColumn(name = "donhang")
    private Donhang donhang ;

}
