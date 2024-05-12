package libroswebapp.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author guzman
 */
@Entity
@Table(name = "EDITORIAL")
public class EditorialEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EDITORIALID")
    private Integer editorialid;
    @Basic(optional = false)
    @Column(name = "EDITORIALNAME", nullable = false, length = 255)
    private String editorialname;
    @Column(name = "EDITORIALWEB", length = 255)
    private String editorialweb;
    @OneToMany(mappedBy = "editorialid")
    private List<LibroEntity> libroList;

    public EditorialEntity() {
    }

    public EditorialEntity(Integer editorialid) {
        this.editorialid = editorialid;
    }

    public EditorialEntity(Integer editorialid, String editorialname) {
        this.editorialid = editorialid;
        this.editorialname = editorialname;
    }

    public Integer getEditorialid() {
        return editorialid;
    }

    public void setEditorialid(Integer editorialid) {
        this.editorialid = editorialid;
    }

    public String getEditorialname() {
        return editorialname;
    }

    public void setEditorialname(String editorialname) {
        this.editorialname = editorialname;
    }

    public String getEditorialweb() {
        return editorialweb;
    }

    public void setEditorialweb(String editorialweb) {
        this.editorialweb = editorialweb;
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
        hash += (editorialid != null ? editorialid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EditorialEntity)) {
            return false;
        }
        EditorialEntity other = (EditorialEntity) object;
        if ((this.editorialid == null && other.editorialid != null) || (this.editorialid != null && !this.editorialid.equals(other.editorialid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libroswebapp.entity.Editorial[ editorialid=" + editorialid + " ]";
    }
    
}
