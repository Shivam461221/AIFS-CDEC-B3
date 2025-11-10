package com.clinic.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clinic.app.dto.RegisterUserRequest;
import com.clinic.app.entities.Role;
import com.clinic.app.entities.User;
import com.clinic.app.exception.ResourceNotFoundException;
import com.clinic.app.repos.UserRepository;

@Service
public class ReceptionistService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ Get all receptionists (Admin only)
    public List<User> getAllReceptionists() {
        return userRepository.findAll()
                .stream()
                .filter(u -> u.getRole() == Role.ROLE_RECEPTIONIST)
                .toList();
    }

    // ✅ Get all receptionists under a specific doctor
    public List<User> getReceptionistsByDoctor(Long doctorId) {
        return userRepository.findByDoctorIdAndRole(doctorId, Role.ROLE_RECEPTIONIST);
    }
    
    public User addReceptionist(RegisterUserRequest request, Long doctorId) {
        System.out.println(doctorId);
        User doctor = userRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

        // Create receptionist user
        User receptionist = new User();
        receptionist.setName(request.getName());
        receptionist.setEmail(request.getEmail());
        receptionist.setPassword(passwordEncoder.encode(request.getPassword()));
        receptionist.setRole(Role.ROLE_RECEPTIONIST);
        receptionist.setDoctor(doctor);

        return userRepository.save(receptionist);
    }
    
    //getById
    
    //update

    // ✅ Delete receptionist (Admin or Doctor)
    public void deleteReceptionist(Long receptionistId, Long doctorId, boolean isAdmin) {
        User receptionist = userRepository.findById(receptionistId)
                .orElseThrow(() -> new ResourceNotFoundException("Receptionist not found"));

        // Doctor can delete only their receptionists
        if (!isAdmin && (receptionist.getDoctor() == null ||
                !receptionist.getDoctor().getId().equals(doctorId))) {
            throw new ResourceNotFoundException("Not allowed to delete this receptionist");
        }

        userRepository.deleteById(receptionistId);
    }
}

