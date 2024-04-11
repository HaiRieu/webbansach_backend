package bansach.demo.Repositority;

import bansach.demo.model.Hinhthucgiaohang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "hinhthucgiaohang")
public interface hinhthucghRepositoryti extends JpaRepository<Hinhthucgiaohang , Integer> {

}
