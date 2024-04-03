package libroswebapp.dao;

import libroswebapp.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository <LibroEntity, Integer> {
}
