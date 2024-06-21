package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "DIETA")
public class Dieta {
    @Id
    @Column(name = "dieta_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dietista_id")
    private Usuario dietista;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

}