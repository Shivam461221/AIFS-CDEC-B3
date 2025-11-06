package com.clinic.app.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public class AppointmentRequest {

	@NotNull(message = "Appointment date is required")
	@Future(message = "Appointment date must be in the future")
	private LocalDate appointmentDate;

	@NotNull(message = "Patient ID is required")
	private Long patientId;

	@NotNull(message = "Doctor ID is required")
	private Long doctorId;

	private Long receptionistId; // if booked by receptionist

	public AppointmentRequest(
			@NotNull(message = "Appointment date is required") @Future(message = "Appointment date must be in the future") LocalDate appointmentDate,
			@NotNull(message = "Patient ID is required") Long patientId,
			@NotNull(message = "Doctor ID is required") Long doctorId, Long receptionistId) {
		super();
		this.appointmentDate = appointmentDate;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.receptionistId = receptionistId;
	}

	public AppointmentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getReceptionistId() {
		return receptionistId;
	}

	public void setReceptionistId(Long receptionistId) {
		this.receptionistId = receptionistId;
	}

}
