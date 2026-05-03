package com.medinovaa.appointment.dto;

public class AppointmentResponse {
    private String appointmentId;
    private String status;
    private String message;
    private DoctorAvailabilityResponse doctor;

    public AppointmentResponse() {
    }

    public AppointmentResponse(String appointmentId, String status, String message, DoctorAvailabilityResponse doctor) {
        this.appointmentId = appointmentId;
        this.status = status;
        this.message = message;
        this.doctor = doctor;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DoctorAvailabilityResponse getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorAvailabilityResponse doctor) {
        this.doctor = doctor;
    }
}
