package taw.webdeentrenamiento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SesionEjercicioClienteId implements java.io.Serializable{
    private static final long serialVersionUID = -6459298132423222146L;
    @Column(name = "sesion_ejercicio_id", nullable = false)
    private Integer sesionEjercicioId;

    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SesionEjercicioClienteId entity = (SesionEjercicioClienteId) o;
        return Objects.equals(this.sesionEjercicioId, entity.sesionEjercicioId) &&
                Objects.equals(this.usuarioId, entity.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sesionEjercicioId, usuarioId);
    }

}