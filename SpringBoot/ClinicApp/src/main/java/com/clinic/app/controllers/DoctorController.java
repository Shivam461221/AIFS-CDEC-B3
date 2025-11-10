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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.app.entities.User;
import com.clinic.app.services.DoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // ✅ Admin: Get all doctors
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    // ✅ Doctor: View own profile
    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/me")
    public ResponseEntity<User> getDoctorProfile(Principal principal) {
        Long doctorId = getUserIdFromPrincipal(principal);
        return ResponseEntity.ok(doctorService.getDoctorProfile(doctorId));
    }

    // ✅ Doctor: View own receptionists
    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/receptionists")
    public ResponseEntity<List<User>> getMyReceptionists(Principal principal) {
        Long doctorId = getUserIdFromPrincipal(principal);
        return ResponseEntity.ok(doctorService.getMyReceptionists(doctorId));
    }

    // ✅ Doctor: View own patients
    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/patients")
    public ResponseEntity<Object> getMyPatients(Principal principal) {
        Long doctorId = getUserIdFromPrincipal(principal);
        return ResponseEntity.ok(doctorService.getMyPatients(doctorId));
    }

    // ✅ Admin: Delete a doctor
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }

    // 🔒 Mock: Replace with JWT user extraction logic
    private Long getUserIdFromPrincipal(Principal principal) {
        // TODO: Extract doctor ID from JWT claims
        return 1L; // placeholder
    }
}
