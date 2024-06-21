package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.Dieta;

public interface DietaRepository extends JpaRepository<Dieta, Integer> {
}
