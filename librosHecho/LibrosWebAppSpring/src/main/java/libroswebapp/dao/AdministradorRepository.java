package libroswebapp.dao;

import libroswebapp.entity.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Integer> {


    @Query("select a from AdministradorEntity a where a.email = :user and a.password = :pwd")
    public AdministradorEntity autentica (@Param("user") String user, @Param("pwd")String pwd);

}
