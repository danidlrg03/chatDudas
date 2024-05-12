package libroswebapp.dao;

import libroswebapp.entity.EditorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialRepository extends JpaRepository<EditorialEntity, Integer> {
}
