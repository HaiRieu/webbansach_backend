package bansach.demo.Repositority;

import bansach.demo.model.Chitietdonhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(path = "chitietdh")
public interface chitietdonhangRepositority  extends JpaRepository<Chitietdonhang , Integer> {

}
