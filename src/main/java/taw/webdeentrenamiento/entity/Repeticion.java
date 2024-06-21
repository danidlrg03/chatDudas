package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "REPETICION")
public class Repeticion {
    @Id
    @Column(name = "repeticiones_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sesion_ejercicio_id")
    private SesionEjercicio sesionEjercicio;

    @Column(name = "numero_repeticion_asignado")
    private Integer numeroRepeticionAsignado;

    @Column(name = "numero_repeticion_completado")
    private Integer numeroRepeticionCompletado;

    @Column(name = "peso")
    private Integer peso;

}