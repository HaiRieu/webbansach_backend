package bansach.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "hinhthucgiaohang")
public class Hinhthucgiaohang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mahtgiaohang")
    private int mahtgiaohang ;

    @Column(name = "tenhinhthucgh")
    private String tenhinhthucgiaohang ;

    @Column(name = "mota")
    private String mota ;

    @Column(name = "chiphigiaohang")
    private double chiphigiaohang ;

    @OneToMany(mappedBy = "hinhthucgiaohang",fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<Donhang> dsdonhang ;

}
