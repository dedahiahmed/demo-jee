package mr.iscae.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "name cannot be empty or null")
    @Size(min = 3, message = "length cannot be low than 3 character")
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "matricule", nullable = false, length = 7, unique = true, updatable = false)
    @NotBlank(message = "name cannot be empty or null")
    @Size(min = 7, message = "length cannot be low than 7 character")
    private String matricule;
    @Email(message = "email provided incorrect")
    @Column(name = "email", unique = true)
    private String email;
}
