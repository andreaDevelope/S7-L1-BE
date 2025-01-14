package it.epicode.S7_L1_BE.web.security.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.epicode.S7_L1_BE.db.pojo.Dipendente;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.PERSIST)
    Dipendente dipendente;

}
