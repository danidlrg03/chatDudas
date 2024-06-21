package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.Ingesta;

public interface IngestaRepository extends JpaRepository<Ingesta, Integer> {
}
