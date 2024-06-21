package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.Repeticion;

public interface RepeticionRepository extends JpaRepository<Repeticion, Integer> {
}
