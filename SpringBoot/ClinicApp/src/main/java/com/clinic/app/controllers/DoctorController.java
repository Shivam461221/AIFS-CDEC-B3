package com.clinic.app.controllers;

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
    public ResponseEntity<User> getDoctorProfile() {
        Long doctorId = getLoggedInUserId();
        System.out.println("👨‍⚕️ Viewing profile for doctorId: " + doctorId);
        return ResponseEntity.ok(doctorService.getDoctorProfile(doctorId));
    }

    // ✅ Doctor: View own receptionists
    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/receptionists")
    public ResponseEntity<List<User>> getMyReceptionists() {
        Long doctorId = getLoggedInUserId();
        return ResponseEntity.ok(doctorService.getMyReceptionists(doctorId));
    }

    // ✅ Doctor: View own patients
    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/patients")
    public ResponseEntity<Object> getMyPatients() {
        Long doctorId = getLoggedInUserId();
        System.out.println("🧑‍⚕️ Fetching patients for doctorId: " + doctorId);
        return ResponseEntity.ok(doctorService.getMyPatients(doctorId));
    }

    // ✅ Admin: Delete a doctor
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        System.out.println("🗑️ Admin deleting doctor with ID: " + id);
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }

    // 🔒 Helper: Extract logged-in doctor ID from JWT token (via SecurityContext)
    private Long getLoggedInUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object credentials = auth.getCredentials();
        if (credentials instanceof Long) {
            return (Long) credentials;
        }
        return null;
    }

    // 🔒 Helper: Check if logged-in user is admin
    private boolean isAdminUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
