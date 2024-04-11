package bansach.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sudanhgia")
public class Sudanhgia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "madanhgia")
  private long madanhgia ;

  @Column(name = "nhanxet")
  private String nhanxet ;

  @ManyToOne(cascade = {
          CascadeType.PERSIST , CascadeType.MERGE,
          CascadeType.DETACH , CascadeType.REFRESH
  })
  @JoinColumn(name = "masach")
  private Sach sach ;

  @Column(name = "hang")
  private  int hang ;

  @ManyToOne(cascade = {
          CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH
  })
  @JoinColumn(name = "makhachhang")
  private Khachhang khachhang ;

}
