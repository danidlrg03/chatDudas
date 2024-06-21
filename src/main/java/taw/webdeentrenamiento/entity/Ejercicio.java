package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EJERCICIO")
public class Ejercicio {
    @Id
    @Column(name = "ejercicio_id", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "url_video", nullable = false)
    private String urlVideo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupo_muscular_id")
    private GrupoMuscular grupoMuscular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}