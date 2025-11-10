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

import com.clinic.app.dto.RegisterUserRequest;
import com.clinic.app.entities.User;
import com.clinic.app.services.ReceptionistService;

@RestController
@RequestMapping("/receptionist")
@CrossOrigin
public class ReceptionistController {

    @Autowired
    private ReceptionistService receptionistService;
    
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR')")
    @PostMapping("/add")
    public ResponseEntity<User> addReceptionist(@RequestBody RegisterUserRequest request) {
        Long doctorId;

        // If admin adds, doctorId must come from request
        // If doctor adds, get from token (Principal)
        if (isAdminUser() && request.getDoctorId() != null) {
            doctorId = request.getDoctorId();
        } else {
            doctorId = getUserIdFromPrincipal();
        }
        System.out.println(doctorId);
        User receptionist = receptionistService.addReceptionist(request, doctorId);
        return ResponseEntity.ok(receptionist);
    }

    // ✅ Admin: Get all receptionists
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllReceptionists() {
        return ResponseEntity.ok(receptionistService.getAllReceptionists());
    }

       
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReceptionist(@PathVariable Long id) {
        boolean isAdmin = isAdminUser();
        Long doctorId = getLoggedInUserId();
        System.out.println("🗑️ Deleting receptionist (requested by doctorId=" + doctorId + ", isAdmin=" + isAdmin + ")");
        receptionistService.deleteReceptionist(id, doctorId, isAdmin);
        return ResponseEntity.ok("Receptionist deleted successfully");
    }
    
    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/my")
    public ResponseEntity<List<User>> getDoctorReceptionists() {
        Long doctorId = getLoggedInUserId(); // ✅ now fetched from JWT
        System.out.println("🩺 Doctor ID from token: " + doctorId);
        return ResponseEntity.ok(receptionistService.getReceptionistsByDoctor(doctorId));
    }

    private Long getUserIdFromPrincipal() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object credentials = auth.getCredentials();
        if (credentials instanceof Long) {
            return (Long) credentials; // ✅ This comes from JWT claim "id"
        }
        return null;
    }
    
    private Long getLoggedInUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object credentials = auth.getCredentials();
        if (credentials instanceof Long) {
            return (Long) credentials;
        }
        return null;
    }

    private boolean isAdminUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}

