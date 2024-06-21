package taw.webdeentrenamiento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CATEGORIA")
public class Categoria {
    @Id
    @Column(name = "categoria_id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

}