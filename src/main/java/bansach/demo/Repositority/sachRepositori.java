package bansach.demo.Repositority;


import bansach.demo.model.Sach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "sach")
public interface sachRepositori extends JpaRepository<Sach , Integer> {

    Page<Sach> findByTensachContaining(@RequestParam("tensach") String tensach , Pageable pageable) ;
    Page<Sach> findByDanhsachtheloai_matheloai (@RequestParam("matheloai") int matheloai , Pageable pageable) ;
    Page<Sach> findByTensachContainingAndDanhsachtheloai_matheloai ( @RequestParam("tensach")  String tensach ,
                                                                      @RequestParam("matheloai") int matheloai
                                                                           ,Pageable pageable) ;

  }
