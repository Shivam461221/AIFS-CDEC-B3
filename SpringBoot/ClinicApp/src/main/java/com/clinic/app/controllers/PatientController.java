package com.clinic.app.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.app.dto.PatientRequest;
import com.clinic.app.entities.Patient;
import com.clinic.app.services.PatientService;

@RestController
@RequestMapping("/patients")
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientService patientService;

    // ✅ Public Booking API (no login required)
    @PostMapping("/book")
    public ResponseEntity<Patient> bookAppointment(@RequestBody PatientRequest request) {
        return ResponseEntity.ok(patientService.bookAppointment(request));
    }

    // ✅ Receptionist adds new patient (requires authentication)
    @PreAuthorize("hasRole('RECEPTIONIST')")
    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody PatientRequest request, Principal principal) {
        // Assuming receptionist email is username
        return ResponseEntity.ok(patientService.addPatient(request, getUserIdFromPrincipal(principal)));
    }

    // ✅ Receptionist views own patients
    @PreAuthorize("hasRole('RECEPTIONIST')")
    @GetMapping("/my")
    public ResponseEntity<List<Patient>> getMyPatients(Principal principal) {
        return ResponseEntity.ok(patientService.getPatientsByReceptionist(getUserIdFromPrincipal(principal)));
    }

    // ✅ Doctor views their patients
    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/doctor")
    public ResponseEntity<List<Patient>> getDoctorPatients(Principal principal) {
        return ResponseEntity.ok(patientService.getPatientsByDoctor(getUserIdFromPrincipal(principal)));
    }

    // ✅ Admin or Doctor deletes a patient
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR', 'RECEPTIONIST')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }

    // 🔒 Helper method
    private Long getUserIdFromPrincipal(Principal principal) {
        // Extract from principal or JWT claims (custom implementation)
        // For now, you can pass receptionist/doctor ID explicitly
        return 1L;
    }
}
