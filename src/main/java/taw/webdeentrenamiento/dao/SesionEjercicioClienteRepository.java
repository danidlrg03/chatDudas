package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.SesionEjercicioCliente;

public interface SesionEjercicioClienteRepository extends JpaRepository<SesionEjercicioCliente, Integer> {
}
