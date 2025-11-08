package com.clinic.app.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequest {
	
	 @NotBlank(message = "Name is required")
	    private String name;

	    @Min(value = 1, message = "Invalid age")
	    private Integer age;

	    @NotBlank(message = "Sex is required")
	    private String sex;
	    
	    @NotBlank(message = "Appointment Date is required")
	    private LocalDate appointmentDate;

	    @NotBlank(message = "Phone number is required")
	    @Size(min = 10, max = 10, message = "Phone should be 10 digits")
	    private String phone;

	    private String diagnosis;

	    // For mapping to doctor/receptionist
	    private Long receptionistId;
	    
	    private Long doctorId;
	    
		
		public PatientRequest(@NotBlank(message = "Name is required") String name,
				@Min(value = 1, message = "Invalid age") Integer age, @NotBlank(message = "Sex is required") String sex,
				@NotBlank(message = "Appointment Date is required") LocalDate appointmentDate,
				@NotBlank(message = "Phone number is required") @Size(min = 10, max = 10, message = "Phone should be 10 digits") String phone,
				String diagnosis, Long receptionistId, Long doctorId) {
			super();
			this.name = name;
			this.age = age;
			this.sex = sex;
			this.appointmentDate = appointmentDate;
			this.phone = phone;
			this.diagnosis = diagnosis;
			this.receptionistId = receptionistId;
			this.doctorId = doctorId;
		}
		
		
		public LocalDate getAppointmentDate() {
			return appointmentDate;
		}


		public void setAppointmentDate(LocalDate appointmentDate) {
			this.appointmentDate = appointmentDate;
		}


		public PatientRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getDiagnosis() {
			return diagnosis;
		}
		public void setDiagnosis(String diagnosis) {
			this.diagnosis = diagnosis;
		}
		public Long getReceptionistId() {
			return receptionistId;
		}
		public void setReceptionistId(Long receptionistId) {
			this.receptionistId = receptionistId;
		}
		public Long getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(Long doctorId) {
			this.doctorId = doctorId;
		}
	    
	    
}
