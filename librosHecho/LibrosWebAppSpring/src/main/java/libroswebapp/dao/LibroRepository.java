package libroswebapp.dao;

import libroswebapp.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository <LibroEntity, Integer> {


    @Query("select l from LibroEntity l where l.libroname like concat('%', :filtro, '%') and l.yearreleased > :anyo")
    public List<LibroEntity> buscarPorPalabraEnTituloYAno (@Param("filtro") String filtro,
                                                           @Param("anyo") short anyo);

}
