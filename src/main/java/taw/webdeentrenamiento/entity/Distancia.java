package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DISTANCIA")
public class Distancia {
    @Id
    @Column(name = "distancia_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sesion_ejercicio_id")
    private SesionEjercicio sesionEjercicio;

    @Column(name = "distancia_km_asignado")
    private Integer distanciaKmAsignado;

    @Column(name = "distancia_km_completado")
    private Integer distanciaKmCompletado;

}