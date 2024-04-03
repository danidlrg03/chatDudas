package libroswebapp.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author guzman
 */
@Entity
@Table(name = "LIBRO")
public class LibroEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LIBROID")
    private Integer libroid;
    @Basic(optional = false)
    @Column(name = "LIBRONAME", nullable = false, length = 255)
    private String libroname;
    @Basic(optional = false)
    @Column(name = "YEARRELEASED", nullable = false)
    private short yearreleased;
    @JoinTable(name = "LIBROGENERO", joinColumns = {
        @JoinColumn(name = "LIBROID", referencedColumnName = "LIBROID")}, inverseJoinColumns = {
        @JoinColumn(name = "GENEROID", referencedColumnName = "GENEROID")})
    @ManyToMany
    private List<GeneroEntity> generoList;
    @JoinTable(name = "LIBROAUTOR", joinColumns = {
        @JoinColumn(name = "LIBROID", referencedColumnName = "LIBROID")}, inverseJoinColumns = {
        @JoinColumn(name = "ESCRITORID", referencedColumnName = "ESCRITORID")})
    @ManyToMany
    private List<EscritorEntity> escritorList;
    @JoinColumn(name = "EDITORIALID", referencedColumnName = "EDITORIALID")
    @ManyToOne
    private EditorialEntity editorialid;

    public LibroEntity() {
    }

    public LibroEntity(Integer libroid) {
        this.libroid = libroid;
    }

    public LibroEntity(Integer libroid, String libroname, short yearreleased) {
        this.libroid = libroid;
        this.libroname = libroname;
        this.yearreleased = yearreleased;
    }

    public Integer getLibroid() {
        return libroid;
    }

    public void setLibroid(Integer libroid) {
        this.libroid = libroid;
    }

    public String getLibroname() {
        return libroname;
    }

    public void setLibroname(String libroname) {
        this.libroname = libroname;
    }

    public short getYearreleased() {
        return yearreleased;
    }

    public void setYearreleased(short yearreleased) {
        this.yearreleased = yearreleased;
    }

    public List<GeneroEntity> getGeneroList() {
        return generoList;
    }

    public void setGeneroList(List<GeneroEntity> generoList) {
        this.generoList = generoList;
    }

    public List<EscritorEntity> getEscritorList() {
        return escritorList;
    }

    public void setEscritorList(List<EscritorEntity> escritorList) {
        this.escritorList = escritorList;
    }

    public EditorialEntity getEditorialid() {
        return editorialid;
    }

    public void setEditorialid(EditorialEntity editorialid) {
        this.editorialid = editorialid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libroid != null ? libroid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO:º Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroEntity)) {
            return false;
        }
        LibroEntity other = (LibroEntity) object;
        if ((this.libroid == null && other.libroid != null) || (this.libroid != null && !this.libroid.equals(other.libroid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libroswebapp.entity.Libro[ libroid=" + libroid + " ]";
    }

}
