package libroswebapp.dao;

import libroswebapp.entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<GeneroEntity, Integer> {
}