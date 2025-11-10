package com.clinic.app.controllers;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.app.entities.Appointment;
import com.clinic.app.entities.AppointmentStatus;
import com.clinic.app.services.AppointmentService;

@RestController
@RequestMapping("/appointments")
@CrossOrigin
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // ✅ Public: book appointment (patient)
    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(@RequestParam Long patientId,
                                                       @RequestParam Long doctorId,
                                                       @RequestParam String reason,
                                                       @RequestParam LocalDateTime dateTime) {
        return ResponseEntity.ok(appointmentService.bookAppointment(patientId, doctorId, dateTime, reason));
    }

    // ✅ Receptionist: add appointment manually
    @PreAuthorize("hasRole('RECEPTIONIST')")
    @PostMapping("/add")
    public ResponseEntity<Appointment> addAppointment(@RequestParam Long patientId,
                                                      @RequestParam Long doctorId,
                                                      @RequestParam String reason,
                                                      @RequestParam LocalDateTime dateTime,
                                                      Principal principal) {
        Long receptionistId = getUserIdFromPrincipal(principal);
        return ResponseEntity.ok(appointmentService.addAppointmentByReceptionist(patientId, doctorId, receptionistId, dateTime, reason));
    }

    // ✅ Doctor: update appointment status
    @PreAuthorize("hasRole('DOCTOR')")
    @PutMapping("/{id}/status")
    public ResponseEntity<Appointment> updateStatus(@PathVariable Long id,
                                                    @RequestParam AppointmentStatus status) {
        return ResponseEntity.ok(appointmentService.updateAppointmentStatus(id, status));
    }

    // ✅ Doctor: view own appointments
    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/doctor")
    public ResponseEntity<List<Appointment>> getDoctorAppointments(Principal principal) {
        Long doctorId = getUserIdFromPrincipal(principal);
        return ResponseEntity.ok(appointmentService.getAppointmentsForDoctor(doctorId));
    }

    // ✅ Receptionist: view their appointments
    @PreAuthorize("hasRole('RECEPTIONIST')")
    @GetMapping("/receptionist")
    public ResponseEntity<List<Appointment>> getReceptionistAppointments(Principal principal) {
        Long receptionistId = getUserIdFromPrincipal(principal);
        return ResponseEntity.ok(appointmentService.getAppointmentsForReceptionist(receptionistId));
    }

    // ✅ Patient: view their appointments
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<Appointment>> getPatientAppointments(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentsForPatient(id));
    }

    // ✅ Admin/Doctor: delete appointment
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok("Appointment deleted successfully");
    }

    // Temporary mock
    private Long getUserIdFromPrincipal(Principal principal) {
        // TODO: Extract user ID from JWT claims in future
        return 1L;
    }
}
