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
@Table(name = "ALIMENTO")
public class Alimento {
    @Id
    @Column(name = "alimento_id", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "calorias_por_gramo", nullable = false)
    private Integer caloriasPorGramo;

}