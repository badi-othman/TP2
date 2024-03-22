package ma.emsi.medicalapp.repository;

import ma.emsi.medicalapp.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {

}
