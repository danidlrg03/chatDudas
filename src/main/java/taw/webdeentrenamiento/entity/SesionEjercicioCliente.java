package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "SESIONEJERCICIOCLIENTE")
public class SesionEjercicioCliente {
    @EmbeddedId
    private SesionEjercicioClienteId id;

    @MapsId("sesionEjercicioId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sesion_ejercicio_id", nullable = false)
    private SesionEjercicio sesionEjercicio;

    @MapsId("usuarioId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "porcentaje_completado")
    private Integer porcentajeCompletado;

}