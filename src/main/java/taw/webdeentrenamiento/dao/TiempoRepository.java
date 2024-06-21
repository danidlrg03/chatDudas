package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.Tiempo;

public interface TiempoRepository extends JpaRepository<Tiempo, Integer> {
}
