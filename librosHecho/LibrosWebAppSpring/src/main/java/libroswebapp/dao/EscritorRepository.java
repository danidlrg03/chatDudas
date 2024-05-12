package libroswebapp.dao;

import libroswebapp.entity.EscritorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscritorRepository extends JpaRepository<EscritorEntity, Integer> {
}
