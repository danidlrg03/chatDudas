package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SESIONEJERCICIO")
public class SesionEjercicio {
    @Id
    @Column(name = "sesion_ejercicio_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sesion_id")
    private Sesion sesion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ejercicio_id")
    private Ejercicio ejercicio;

    @Column(name = "numero_ejercicio", nullable = false)
    private Integer numeroEjercicio;

}