package libroswebapp.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 *
 * @author guzman
 */
@Entity
@Table(name = "GENERO")
public class GeneroEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GENEROID")
    private Integer generoid;
    @Basic(optional = false)
    @Column(name = "GENERONAME", nullable = false, length=255)
    private String generoname;
    @ManyToMany(mappedBy = "generoList")
    private List<LibroEntity> libroList;

    public GeneroEntity() {
    }

    public GeneroEntity(Integer generoid) {
        this.generoid = generoid;
    }

    public GeneroEntity(Integer generoid, String generoname) {
        this.generoid = generoid;
        this.generoname = generoname;
    }

    public Integer getGeneroid() {
        return generoid;
    }

    public void setGeneroid(Integer generoid) {
        this.generoid = generoid;
    }

    public String getGeneroname() {
        return generoname;
    }

    public void setGeneroname(String generoname) {
        this.generoname = generoname;
    }

    public List<LibroEntity> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<LibroEntity> libroList) {
        this.libroList = libroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generoid != null ? generoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneroEntity)) {
            return false;
        }
        GeneroEntity other = (GeneroEntity) object;
        if ((this.generoid == null && other.generoid != null) || (this.generoid != null && !this.generoid.equals(other.generoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libroswebapp.entity.Genero[ generoid=" + generoid + " ]";
    }
    
}
