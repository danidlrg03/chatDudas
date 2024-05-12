package libroswebapp.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ADMINISTRADOR")
public class AdministradorEntity {
    private Integer adminId;
    private String email;
    private String password;

    @Id
    @Column(name = "ADMIN_ID", nullable = false)
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof EditorialEntity) return false;
        AdministradorEntity that = (AdministradorEntity) o;
        return Objects.equals(adminId, that.adminId) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, email, password);
    }

}
