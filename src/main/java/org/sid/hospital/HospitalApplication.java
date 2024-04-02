package org.sid.hospital;


import org.sid.hospital.entities.*;
import org.sid.hospital.repository.ConsultationRepository;
import org.sid.hospital.repository.MedecinRepository;
import org.sid.hospital.repository.PatientRepository;
import org.sid.hospital.repository.RendezVousRepository;
import org.sid.hospital.services.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {

        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository, MedecinRepository medecinRepository) {
        return args -> {
            Stream.of("Salma","Yasser","Aya").
                    forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Ayman","Rawane","Anas").
                    forEach(name->{
                        Medecin medecin=new Medecin();
                        medecin.setNom(name+"@gmail.com");
                        medecin.setSpeecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });


            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Mohamed");

            Medecin medecin=medecinRepository.findByNom("Rawane");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveDRDV=hospitalService.saveRDV(rendezVous);
            System.out.println(saveDRDV.getId());

            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation ...");
            hospitalService.saveConsultation(consultation);

        };

    } }