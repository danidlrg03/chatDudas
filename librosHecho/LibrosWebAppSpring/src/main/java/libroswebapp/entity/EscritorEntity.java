
package libroswebapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author guzman
 */
@Entity
@Table(name = "ESCRITOR")
public class EscritorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESCRITORID")
    private Integer escritorid;
    @Basic(optional = false)
    @Column(name = "ESCRITORNAME", nullable = false, length = 255)
    private String escritorname;
    @Basic(optional = false)
    @Column(name = "ESCRITORNACIONALIDAD", nullable = false, length = 50)
    private String escritornacionalidad;
    @Basic(optional = false)
    @Column(name = "ESCRITORNACIMIENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date escritornacimiento;
    @Column(name = "ESCRITORFALLECIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date escritorfallecimiento;
    @ManyToMany(mappedBy = "escritorList")
    private List<LibroEntity> libroList;

    public EscritorEntity() {
    }

    public EscritorEntity(Integer escritorid) {
        this.escritorid = escritorid;
    }

    public EscritorEntity(Integer escritorid, String escritorname, String escritornacionalidad, Date escritornacimiento) {
        this.escritorid = escritorid;
        this.escritorname = escritorname;
        this.escritornacionalidad = escritornacionalidad;
        this.escritornacimiento = escritornacimiento;
    }

    public Integer getEscritorid() {
        return escritorid;
    }

    public void setEscritorid(Integer escritorid) {
        this.escritorid = escritorid;
    }

    public String getEscritorname() {
        return escritorname;
    }

    public void setEscritorname(String escritorname) {
        this.escritorname = escritorname;
    }

    public String getEscritornacionalidad() {
        return escritornacionalidad;
    }

    public void setEscritornacionalidad(String escritornacionalidad) {
        this.escritornacionalidad = escritornacionalidad;
    }

    public Date getEscritornacimiento() {
        return escritornacimiento;
    }

    public void setEscritornacimiento(Date escritornacimiento) {
        this.escritornacimiento = escritornacimiento;
    }

    public Date getEscritorfallecimiento() {
        return escritorfallecimiento;
    }

    public void setEscritorfallecimiento(Date escritorfallecimiento) {
        this.escritorfallecimiento = escritorfallecimiento;
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
        hash += (escritorid != null ? escritorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscritorEntity)) {
            return false;
        }
        EscritorEntity other = (EscritorEntity) object;
        if ((this.escritorid == null && other.escritorid != null) || (this.escritorid != null && !this.escritorid.equals(other.escritorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libroswebapp.entity.Escritor[ escritorid=" + escritorid + " ]";
    }
    
}
