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

    // ✅ Public: Book appointment (no login required)
    @PostMapping("/book")
    public ResponseEntity<Patient> bookAppointment(@RequestBody PatientRequest request) {
        return ResponseEntity.ok(patientService.bookAppointment(request));
    }

    // ✅ Receptionist adds new patient (requires authentication)
    @PreAuthorize("hasRole('RECEPTIONIST')")
    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody PatientRequest request) {
        Long receptionistId = getLoggedInUserId();
        System.out.println("🧾 Adding patient by receptionistId: " + receptionistId);
        return ResponseEntity.ok(patientService.addPatient(request, receptionistId));
    }

    // ✅ Receptionist views own patients
    @PreAuthorize("hasRole('RECEPTIONIST')")
    @GetMapping("/my")
    public ResponseEntity<List<Patient>> getMyPatients() {
        Long receptionistId = getLoggedInUserId();
        System.out.println("👩‍💼 Viewing patients for receptionistId: " + receptionistId);
        return ResponseEntity.ok(patientService.getPatientsByReceptionist(receptionistId));
    }

    // ✅ Doctor views their patients
//    @PreAuthorize("hasRole('DOCTOR')")
//    @GetMapping("/doctor")
//    public ResponseEntity<List<Patient>> getDoctorPatients() {
//        Long doctorId = getLoggedInUserId();
//        System.out.println("👨‍⚕️ Viewing patients for doctorId: " + doctorId);
//        return ResponseEntity.ok(patientService.getPatientsByDoctor(doctorId));
//    }

    // ✅ Admin / Doctor / Receptionist deletes a patient
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR', 'RECEPTIONIST')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        boolean isAdmin = isAdminUser();
        Long userId = getLoggedInUserId();
        System.out.println("🗑️ Deleting patientId=" + id + " requested by userId=" + userId + " (isAdmin=" + isAdmin + ")");
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }

    // 🔒 Extract logged-in user ID from JWT
    private Long getLoggedInUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object credentials = auth.getCredentials();
        if (credentials instanceof Long) {
            return (Long) credentials;
        }
        return null;
    }

    // 🔒 Check if logged-in user is admin
    private boolean isAdminUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
