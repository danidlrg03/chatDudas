package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.Sesion;

public interface SesionRepository extends JpaRepository<Sesion, Integer> {
}
