package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.SesionEjercicio;

public interface SesionEjercicioRepository extends JpaRepository<SesionEjercicio, Integer> {
}
