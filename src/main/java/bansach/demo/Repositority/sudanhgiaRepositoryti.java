package bansach.demo.Repositority;

import bansach.demo.model.Sudanhgia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(path = "sudanhgia")
public interface sudanhgiaRepositoryti extends JpaRepository<Sudanhgia , Integer> {
}
