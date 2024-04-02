package org.sid.hospital.services;

import org.sid.hospital.Consultation;
import org.sid.hospital.entities.Medecin;
import org.sid.hospital.entities.Patient;
import org.sid.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}