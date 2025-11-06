package com.clinic.app.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {
	
	 @Id @GeneratedValue
	    private Long id;

	    private LocalDate appointmentDate;

	    @ManyToOne
	    private Patient patient;

	    @ManyToOne
	    private User doctor;

	    @ManyToOne
	    private User receptionist;

		public Appointment(Long id, LocalDate appointmentDate, Patient patient, User doctor, User receptionist) {
			super();
			this.id = id;
			this.appointmentDate = appointmentDate;
			this.patient = patient;
			this.doctor = doctor;
			this.receptionist = receptionist;
		}

		public Appointment() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDate getAppointmentDate() {
			return appointmentDate;
		}

		public void setAppointmentDate(LocalDate appointmentDate) {
			this.appointmentDate = appointmentDate;
		}

		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
		}

		public User getDoctor() {
			return doctor;
		}

		public void setDoctor(User doctor) {
			this.doctor = doctor;
		}

		public User getReceptionist() {
			return receptionist;
		}

		public void setReceptionist(User receptionist) {
			this.receptionist = receptionist;
		}
	    
	    
}
