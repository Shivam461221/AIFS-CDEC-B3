package com.clinic.app.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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

	    // ✅ Public: patient can book appointment (no authentication required)
	    @PostMapping("/book")
	    public ResponseEntity<Appointment> bookAppointment(
	            @RequestParam Long patientId,
	            @RequestParam Long doctorId,
	            @RequestParam String reason,
	            @RequestParam LocalDateTime dateTime) {

	        System.out.println("📅 Public booking: patientId=" + patientId + ", doctorId=" + doctorId);
	        return ResponseEntity.ok(appointmentService.bookAppointment(patientId, doctorId, dateTime, reason));
	    }

	    // ✅ Receptionist: add appointment manually
	    @PreAuthorize("hasRole('RECEPTIONIST')")
	    @PostMapping("/add")
	    public ResponseEntity<Appointment> addAppointment(
	            @RequestParam Long patientId,
	            @RequestParam Long doctorId,
	            @RequestParam String reason,
	            @RequestParam LocalDateTime dateTime) {

	        Long receptionistId = getLoggedInUserId();
	        System.out.println("💼 Receptionist (id=" + receptionistId + ") adding appointment for doctorId=" + doctorId);

	        return ResponseEntity.ok(
	                appointmentService.addAppointmentByReceptionist(patientId, doctorId, receptionistId, dateTime, reason));
	    }

	    // ✅ Doctor: update appointment status
	    @PreAuthorize("hasAnyRole('DOCTOR', 'RECEPTIONIST')")
	    @PutMapping("/{id}/status")
	    public ResponseEntity<Appointment> updateStatus(
	            @PathVariable Long id,
	            @RequestParam AppointmentStatus status) {

	        System.out.println("🩺 Updating status for appointmentId=" + id + " to " + status);
	        return ResponseEntity.ok(appointmentService.updateAppointmentStatus(id, status));
	    }

	    // ✅ Doctor: view own appointments
	    @PreAuthorize("hasRole('DOCTOR')")
	    @GetMapping("/doctor")
	    public ResponseEntity<List<Appointment>> getDoctorAppointments() {
	        Long doctorId = getLoggedInUserId();
	        System.out.println("🩺 Fetching appointments for doctorId=" + doctorId);
	        return ResponseEntity.ok(appointmentService.getAppointmentsForDoctor(doctorId));
	    }

	    // ✅ Receptionist: view their appointments
	    @PreAuthorize("hasRole('RECEPTIONIST')")
	    @GetMapping("/receptionist")
	    public ResponseEntity<List<Appointment>> getReceptionistAppointments() {
	        Long receptionistId = getLoggedInUserId();
	        System.out.println("💼 Fetching appointments for receptionistId=" + receptionistId);
	        return ResponseEntity.ok(appointmentService.getAppointmentsForReceptionist(receptionistId));
	    }

	    // ✅ Patient: view their appointments
	    @GetMapping("/patient/{id}")
	    public ResponseEntity<List<Appointment>> getPatientAppointments(@PathVariable Long id) {
	        System.out.println("👤 Fetching appointments for patientId=" + id);
	        return ResponseEntity.ok(appointmentService.getAppointmentsForPatient(id));
	    }

	    // ✅ Admin/Doctor: delete appointment
	    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR')")
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
	        boolean isAdmin = isAdminUser();
	        Long userId = getLoggedInUserId();
	        System.out.println("🗑️ Deleting appointmentId=" + id + " by userId=" + userId + " (isAdmin=" + isAdmin + ")");
	        appointmentService.deleteAppointment(id);
	        return ResponseEntity.ok("Appointment deleted successfully");
	    }

	    // 🔒 Helper: extract userId from JWT (via SecurityContext)
	    private Long getLoggedInUserId() {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        Object credentials = auth.getCredentials();
	        if (credentials instanceof Long) {
	            return (Long) credentials;
	        }
	        return null;
	    }

	    // 🔒 Helper: check if current user is admin
	    private boolean isAdminUser() {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        return auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
	    }
}
