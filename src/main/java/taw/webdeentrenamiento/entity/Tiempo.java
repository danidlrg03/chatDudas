package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TIEMPO")
public class Tiempo {
    @Id
    @Column(name = "tiempo_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sesion_ejercicio_id")
    private SesionEjercicio sesionEjercicio;

    @Column(name = "tiempo_en_segundos_asignado")
    private Integer tiempoEnSegundosAsignado;

    @Column(name = "tiempo_en_segundos_completado")
    private Integer tiempoEnSegundosCompletado;

}