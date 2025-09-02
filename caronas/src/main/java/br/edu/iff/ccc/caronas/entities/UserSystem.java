package br.edu.iff.ccc.caronas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(
    name = "users",
    indexes = @Index(name = "idx_users_email_unique", columnList = "email", unique = true)
)
public class UserSystem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{user.name.notEmpty}")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "{user.email.notEmpty}")
    @Email(message = "{user.email.invalid}")
    @Column(nullable = false, unique = true, length = 190)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 100)
    private String passwordHash;

    @Column(nullable = false, length = 20)
    private String status = "ATIVO";

    @Column(nullable = false, length = 20)
    private String role = "USER";

    public UserSystem() {}

    public UserSystem(Long id, String name, String email, String passwordHash, String status, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.status = status;
        this.role = role;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @PrePersist
    public void prePersist() {
        if (status == null || status.isBlank()) status = "ATIVO";
        if (role == null || role.isBlank()) role = "USER";
        if (email != null) email = email.trim().toLowerCase();
        if (name  != null) name  = name.trim();
    }

    @PreUpdate
    public void preUpdate() {
        if (email != null) email = email.trim().toLowerCase();
        if (name  != null) name  = name.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSystem u)) return false;
        return id != null && id.equals(u.id);
    }

    @Override
    public int hashCode() { return 31; }
}
