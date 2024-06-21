package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "INGESTAALIMENTOUSUARIO")
public class IngestaAlimentoUsuario {
    @EmbeddedId
    private IngestaAlimentoUsuarioId id;

    @MapsId("usuarioId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @MapsId("alimentoId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alimento_id", nullable = false)
    private Alimento alimento;

    @MapsId("ingestasId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingestas_id", nullable = false)
    private Ingesta ingestas;

    @Column(name = "gramos_consumidos")
    private Integer gramosConsumidos;

    @Column(name = "calorias_consumidos")
    private Integer caloriasConsumidos;

    @Column(name = "feedback", length = 45)
    private String feedback;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

}