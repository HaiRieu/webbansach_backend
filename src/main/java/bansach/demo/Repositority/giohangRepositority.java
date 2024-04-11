package bansach.demo.Repositority;

import bansach.demo.model.Giohang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(path = "giohang")
public interface giohangRepositority extends JpaRepository<Giohang , Integer > {
}
