package taw.webdeentrenamiento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import taw.webdeentrenamiento.entity.MenuDiario;

public interface MenuDiarioRepository extends JpaRepository<MenuDiario, Integer> {
}
