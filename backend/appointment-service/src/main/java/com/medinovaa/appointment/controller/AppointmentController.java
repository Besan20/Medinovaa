package com.medinovaa.appointment.controller;

import com.medinovaa.appointment.dto.AppointmentRequest;
import com.medinovaa.appointment.dto.AppointmentResponse;
import com.medinovaa.appointment.dto.DoctorAvailabilityResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final RestClient restClient;
    private final String doctorServiceUrl;

    public AppointmentController(RestClient restClient, @Value("${doctor.service.url}") String doctorServiceUrl) {
        this.restClient = restClient;
        this.doctorServiceUrl = doctorServiceUrl;
    }

    @PostMapping
    public ResponseEntity<AppointmentResponse> createAppointment(@RequestBody AppointmentRequest request) {
        DoctorAvailabilityResponse doctor = restClient.get()
                .uri(doctorServiceUrl + "/doctors/{doctorId}/availability", request.getDoctorId())
                .retrieve()
                .body(DoctorAvailabilityResponse.class);

        if (doctor == null || !doctor.isAvailable()) {
            AppointmentResponse response = new AppointmentResponse(
                    null,
                    "REJECTED",
                    "Appointment was rejected because the doctor is not available",
                    doctor
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        AppointmentResponse response = new AppointmentResponse(
                UUID.randomUUID().toString(),
                "CONFIRMED",
                "Appointment created successfully for patient " + request.getPatientId() + " on " + request.getDate(),
                doctor
        );

        return ResponseEntity.ok(response);
    }
}
