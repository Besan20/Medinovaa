package com.medinovaa.doctor.dto;

public class DoctorAvailabilityResponse {
    private String doctorId;
    private String doctorName;
    private boolean available;
    private String specialization;
    private String message;

    public DoctorAvailabilityResponse() {
    }

    public DoctorAvailabilityResponse(String doctorId, String doctorName, boolean available, String specialization, String message) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.available = available;
        this.specialization = specialization;
        this.message = message;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
