package bansach.demo.Repositority;

import bansach.demo.model.Hinhthucthanhtoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "hinhthucthanhtoan")
public interface hinhthucttRepositoryti extends JpaRepository<Hinhthucthanhtoan , Integer> {
}
