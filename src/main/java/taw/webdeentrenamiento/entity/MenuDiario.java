package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MENU_DIARIO")
public class MenuDiario {
    @Id
    @Column(name = "menu_id", nullable = false)
    private Integer id;

    @Column(name = "dia_semana", nullable = false)
    private Integer diaSemana;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dieta_id")
    private Dieta dieta;

}