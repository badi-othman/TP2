package ma.emsi.medicalapp.repository;

import ma.emsi.medicalapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
