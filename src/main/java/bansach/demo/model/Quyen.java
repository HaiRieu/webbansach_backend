package bansach.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "quyen")
public class Quyen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maquyen")
    private int maquyen ;

    @Column(name = "tenquyen")
    private String tenquyen ;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(
            name = "khachhang_quyen",
            joinColumns = @JoinColumn(name = "maquyen"),
            inverseJoinColumns = @JoinColumn(name = "makhachhang")
    )
    private List<Khachhang> dskhachhang ;

}
