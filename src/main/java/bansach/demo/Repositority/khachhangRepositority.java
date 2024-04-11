package bansach.demo.Repositority;

import bansach.demo.model.Khachhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "khachhang")
public interface khachhangRepositority extends JpaRepository<Khachhang , Integer > {
            public boolean existsByTendangnhap(String tendangnhap) ;

            public boolean existsByEmail(String dcemail) ;

            public Khachhang findByTendangnhap(String tenkhachhang) ;

}
