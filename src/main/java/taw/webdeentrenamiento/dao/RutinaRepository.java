package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.Rutina;

import java.util.Optional;

public interface RutinaRepository extends JpaRepository<Rutina, Integer> {

    Optional<Rutina> findById(Integer id);

}
