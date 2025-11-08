package com.clinic.app.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.app.dto.PatientRequest;
import com.clinic.app.entities.Patient;
import com.clinic.app.entities.User;
import com.clinic.app.exception.ResourceNotFoundException;
import com.clinic.app.repos.PatientRepository;
import com.clinic.app.repos.UserRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ Public Booking API
    public Patient bookAppointment(PatientRequest request) {
        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setAge(request.getAge());
        patient.setSex(request.getSex());
        patient.setPhone(request.getPhone());
        patient.setDiagnosis(request.getDiagnosis());
        patient.setAppointmentDate(request.getAppointmentDate());
        return patientRepository.save(patient);
    }

    // ✅ Receptionist adds a patient (authenticated)
    public Patient addPatient(PatientRequest request, Long receptionistId) {
        User receptionist = userRepository.findById(receptionistId)
                .orElseThrow(() -> new ResourceNotFoundException("Receptionist not found"));

        patientRepository.save(mapPatient(request, receptionist));
        return mapPatient(request, receptionist);
    }

    private Patient mapPatient(PatientRequest request, User receptionist) {
        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setAge(request.getAge());
        patient.setSex(request.getSex());
        patient.setPhone(request.getPhone());
        patient.setDiagnosis(request.getDiagnosis());
        patient.setAppointmentDate(request.getAppointmentDate());
        patient.setReceptionist(receptionist);
        patient.setDoctor(receptionist.getDoctor());
        return patient;
    }

    // ✅ Get patients for a specific receptionist
    public List<Patient> getPatientsByReceptionist(Long receptionistId) {
        return patientRepository.findByReceptionistId(receptionistId);
    }

    // ✅ Get patients for a specific doctor
    public List<Patient> getPatientsByDoctor(Long doctorId) {
        return patientRepository.findByDoctorId(doctorId);
    }

    // ✅ Admin or Doctor can delete a patient
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id))
            throw new ResourceNotFoundException("Patient not found");
        patientRepository.deleteById(id);
    }
}

