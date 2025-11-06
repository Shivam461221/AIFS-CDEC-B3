package com.clinic.app.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.app.entities.Role;
import com.clinic.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	
	List<User> findByDoctorIdAndRole(Long doctorId, Role role);
}
