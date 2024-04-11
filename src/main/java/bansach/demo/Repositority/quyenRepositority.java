package bansach.demo.Repositority;

import bansach.demo.model.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "quyen")
public interface quyenRepositority extends JpaRepository<Quyen , Integer> {
}
