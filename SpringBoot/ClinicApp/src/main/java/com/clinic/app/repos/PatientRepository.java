package com.clinic.app.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.app.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	// ✅ Receptionist sees only their registered patients
    List<Patient> findByReceptionistId(Long receptionistId);

    // ✅ Doctor sees only patients assigned to them
    List<Patient> findByDoctorId(Long doctorId);
}
