package spring.repositories;

import base.model.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Cafe, Long> {
}
