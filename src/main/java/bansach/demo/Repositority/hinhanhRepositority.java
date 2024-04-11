package bansach.demo.Repositority;

import bansach.demo.model.Hinhanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "hinhanh")
public interface hinhanhRepositority extends JpaRepository<Hinhanh , Integer> {

}
