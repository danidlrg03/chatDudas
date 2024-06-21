package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "INGESTAS")
public class Ingesta {
    @Id
    @Column(name = "ingestas_id", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "gramos_recomendados")
    private Integer gramosRecomendados;

    @Column(name = "calorias_recomendadas")
    private Integer caloriasRecomendadas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private MenuDiario menu;

}