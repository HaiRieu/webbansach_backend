package bansach.demo.Repositority;

import bansach.demo.model.Donhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "donhang")
public interface donhangRepositority extends JpaRepository<Donhang , Integer> {
}
