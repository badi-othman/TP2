package ma.emsi.medicalapp.repository;

import ma.emsi.medicalapp.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}
