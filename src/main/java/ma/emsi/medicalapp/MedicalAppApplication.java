package ma.emsi.medicalapp;

import ma.emsi.medicalapp.entities.Consultation;
import ma.emsi.medicalapp.entities.Medecin;
import ma.emsi.medicalapp.entities.Patient;
import ma.emsi.medicalapp.entities.RendezVous;
import ma.emsi.medicalapp.repository.ConsultationRepository;
import ma.emsi.medicalapp.repository.MedecinRepository;
import ma.emsi.medicalapp.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ma.emsi.medicalapp.repository.PatientRepository;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class MedicalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalAppApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezvousRepository,
                            ConsultationRepository consultationRepository){
        return args -> {
            //Ajout des patient,medecins,rdv et consultation
            Stream.of("Goku","Vegeta","Piccolo").forEach(name->{
                Patient patient=new Patient();
                patient.setNom(name);
                patient.setAnneeNaissance(1990);
                patient.setMalade(true);
                patientRepository.save(patient);
            });

            Stream.of("Gon","Kurapika","Melody").forEach(name->{
                Medecin medecin=new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardiologue":"Dentiste");
                medecinRepository.save(medecin);
            });

            RendezVous rdv=new RendezVous();
            rdv.setDate(new Date());
            rdv.setAnnule(false);
            rdv.setMedecin(medecinRepository.findById(1L).get());
            rdv.setPatient(patientRepository.findById(1L).get());
            rendezvousRepository.save(rdv);

            Consultation clt=new Consultation();
            clt.setRapport(Math.random()<0.5?"passer des analyses":"sain");
            clt.setDateConsultation(new Date());
            clt.setRendezVous(rendezvousRepository.findById(1L).get());
            consultationRepository.save(clt);

            //chercher un patient avec son id
            Patient patient1=patientRepository.findById(3L).get();
            System.out.println("************");
            System.out.println(patient1.getId());
            System.out.println(patient1.getNom());
            System.out.println(patient1.getAnneeNaissance());
            System.out.println("*************");
            //modifier un patient
            Patient patient2=patientRepository.findById(3L).get();
            patient2.setNom("Son");
            System.out.println(patient1.toString());
            //supprimer un patient
            patientRepository.delete(patient1);
        };

    }
}


