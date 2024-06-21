package taw.webdeentrenamiento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ROL")
public class Rol {
    @Id
    @Column(name = "rol_id", nullable = false)
    private Integer id;

    @Column(name = "rol_name", nullable = false)
    private String rolName;

}