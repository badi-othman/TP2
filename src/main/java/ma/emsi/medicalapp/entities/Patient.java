package ma.emsi.medicalapp.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Nom;
    private int AnneeNaissance;
    private boolean malade;
    @OneToMany(mappedBy="patient",fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;

}
