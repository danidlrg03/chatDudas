package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.Distancia;

public interface DistanciaRepository extends JpaRepository<Distancia, Integer> {
}
