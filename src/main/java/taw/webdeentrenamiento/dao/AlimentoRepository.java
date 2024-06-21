package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.Alimento;


public interface AlimentoRepository extends JpaRepository<Alimento, Integer> {
}
