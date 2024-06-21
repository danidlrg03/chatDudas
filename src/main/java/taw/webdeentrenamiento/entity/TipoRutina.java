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
@Table(name = "TIPO_RUTINA")
public class TipoRutina {
    @Id
    @Column(name = "tipo_rutina_id", nullable = false)
    private Integer id;

    @Column(name = "tipo_rutina", nullable = false, length = 45)
    private String tipoRutina;

}