package com.clinic.app.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.app.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
		
	// ✅ Receptionist sees only appointments they created
    List<Appointment> findByReceptionistId(Long receptionistId);

    // ✅ Doctor sees only appointments assigned to them
    List<Appointment> findByDoctorId(Long doctorId);

    // ✅ Patient should access only their appointments (if needed later)
    List<Appointment> findByPatientId(Long patientId);
}
