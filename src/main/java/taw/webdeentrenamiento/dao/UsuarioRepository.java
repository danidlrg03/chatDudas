package taw.webdeentrenamiento.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import taw.webdeentrenamiento.entity.Rol;
import taw.webdeentrenamiento.entity.Usuario;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.rol.id = ?1")
    List<Usuario> findUsuariosByRolId(Integer rolId);

	//TODO
	Usuario findUsuarioByNombreAndContrasena(String nombreUsuario, String password);


}