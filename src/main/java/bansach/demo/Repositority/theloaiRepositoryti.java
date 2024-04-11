package bansach.demo.Repositority;

import bansach.demo.model.Theloai;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "theloai")
public interface theloaiRepositoryti extends JpaRepository<Theloai , Integer> {




}
