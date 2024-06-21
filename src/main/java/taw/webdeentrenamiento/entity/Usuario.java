package taw.webdeentrenamiento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @Column(name = "usuario_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "peso")
    private Integer peso;

    @Column(name = "altura")
    private Integer altura;

    @Column(name = "edad")
    private Integer edad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rutina_id")
    private Rutina rutina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dieta_id")
    private Dieta dieta;

    // Relación de muchos a uno para asignar un entrenador a un cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrenador_id")
    private Usuario entrenador;

    // Relación de uno a muchos para asignar clientes a un entrenador
    @OneToMany(mappedBy = "entrenador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Usuario> clientes;
}
