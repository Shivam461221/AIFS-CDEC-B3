package com.clinic.app.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.app.entities.Appointment;
import com.clinic.app.entities.AppointmentStatus;
import com.clinic.app.entities.Patient;
import com.clinic.app.entities.User;
import com.clinic.app.exception.ResourceNotFoundException;
import com.clinic.app.repos.AppointmentRepository;
import com.clinic.app.repos.PatientRepository;
import com.clinic.app.repos.UserRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ Public booking
    public Appointment bookAppointment(Long patientId, Long doctorId, LocalDateTime dateTime, String reason) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        User doctor = userRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(dateTime);
        appointment.setReason(reason);
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }

    // ✅ Receptionist adds an appointment manually
    public Appointment addAppointmentByReceptionist(Long patientId, Long doctorId, Long receptionistId,
                                                    LocalDateTime dateTime, String reason) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        User doctor = userRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        User receptionist = userRepository.findById(receptionistId)
                .orElseThrow(() -> new ResourceNotFoundException("Receptionist not found"));

        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(dateTime);
        appointment.setReason(reason);
        appointment.setStatus(AppointmentStatus.CONFIRMED);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setReceptionist(receptionist);

        return appointmentRepository.save(appointment);
    }

    // ✅ Doctor updates appointment status
    public Appointment updateAppointmentStatus(Long appointmentId, AppointmentStatus status) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));
        appointment.setStatus(status);
        return appointmentRepository.save(appointment);
    }

    // ✅ Doctor or receptionist views their appointments
    public List<Appointment> getAppointmentsForDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsForReceptionist(Long receptionistId) {
        return appointmentRepository.findByReceptionistId(receptionistId);
    }

    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    // ✅ Admin/Doctor can delete an appointment
    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id))
            throw new ResourceNotFoundException("Appointment not found");
        appointmentRepository.deleteById(id);
    }
}
