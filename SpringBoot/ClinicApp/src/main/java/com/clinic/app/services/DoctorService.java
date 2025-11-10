package com.clinic.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.app.entities.Role;
import com.clinic.app.entities.User;
import com.clinic.app.exception.ResourceNotFoundException;
import com.clinic.app.repos.PatientRepository;
import com.clinic.app.repos.UserRepository;

@Service
public class DoctorService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    // ✅ Admin: View all doctors
    public List<User> getAllDoctors() {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getRole() == Role.ROLE_DOCTOR)
                .toList();
    }

    // ✅ Admin: Delete doctor
    public void deleteDoctor(Long doctorId) {
        User doctor = userRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        userRepository.delete(doctor);
    }

    // ✅ Doctor: Get own profile
    public User getDoctorProfile(Long doctorId) {
        return userRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
    }

    // ✅ Doctor: Get all their receptionists
    public List<User> getMyReceptionists(Long doctorId) {
        return userRepository.findByDoctorIdAndRole(doctorId, Role.ROLE_RECEPTIONIST);
    }

    // ✅ Doctor: Get all their patients
    public Object getMyPatients(Long doctorId) {
        return patientRepository.findByDoctorId(doctorId);
    }
    
    //update profile 
}

