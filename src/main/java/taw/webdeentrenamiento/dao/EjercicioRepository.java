package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.Ejercicio;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer> {
}
