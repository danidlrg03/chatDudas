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
public class IngestaAlimentoUsuarioId implements java.io.Serializable{
    private static final long serialVersionUID = -3366128212613224130L;
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "alimento_id", nullable = false)
    private Integer alimentoId;

    @Column(name = "ingestas_id", nullable = false)
    private Integer ingestasId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IngestaAlimentoUsuarioId entity = (IngestaAlimentoUsuarioId) o;
        return Objects.equals(this.ingestasId, entity.ingestasId) &&
                Objects.equals(this.usuarioId, entity.usuarioId) &&
                Objects.equals(this.alimentoId, entity.alimentoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingestasId, usuarioId, alimentoId);
    }

}