package bansach.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "theloai")
public class Theloai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matheloai")
    private int matheloai ;

    @Column(name = "tentheloai")
    private String tentheloai ;



    @ManyToMany(fetch = FetchType.LAZY ,
            cascade = {CascadeType.PERSIST , CascadeType.MERGE ,
                    CascadeType.DETACH, CascadeType.REFRESH
            })
    @JoinTable(
            name = "sach_theloai",
            joinColumns = @JoinColumn(name = "matheloai"),
            inverseJoinColumns = @JoinColumn(name = "masach")
    )
    private List<Sach> dsquyensach ;

}
