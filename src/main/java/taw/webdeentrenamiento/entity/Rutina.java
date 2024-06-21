package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "RUTINA")
public class Rutina {
    @Id
    @Column(name = "rutina_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrenador_id")
    private Usuario entrenador;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tipo_rutina_id", nullable = false)
    private TipoRutina tipoRutina;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

}