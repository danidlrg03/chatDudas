package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SESION")
public class Sesion {
    @Id
    @Column(name = "sesion_id", nullable = false)
    private Integer id;

    @Column(name = "dia_semana", nullable = false)
    private Integer diaSemana;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rutina_id")
    private Rutina rutina;

}