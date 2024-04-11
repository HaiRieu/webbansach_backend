package bansach.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "hinhthucthanhtoan")
public class Hinhthucthanhtoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mhtthanhtoan")
    private int mhtthanhtoan ;

    @Column(name = "tenhinhthucthanhtoan")
    private String tenhinhthucthanhtoan ;

    @Column(name = "mota")
    private String mota ;

    @Column(name = "giathanhtoan")
    private double giathanhtoan;

    @OneToMany(mappedBy ="hinhthucthanhtoan" ,fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<Donhang> dsdonhang ;

}
