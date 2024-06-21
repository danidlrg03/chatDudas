package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
