package com.medinovaa.doctor.controller;

import com.medinovaa.doctor.dto.DoctorAvailabilityResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private static final Map<String, String> DOCTORS = Map.of(
            "D101", "Dr. Ahmad - Cardiology",
            "D202", "Dr. Lina - General Medicine",
            "D303", "Dr. Omar - Pediatrics"
    );

    @GetMapping("/{doctorId}/availability")
    public DoctorAvailabilityResponse checkAvailability(@PathVariable String doctorId) {
        String doctorInfo = DOCTORS.get(doctorId);

        if (doctorInfo == null) {
            return new DoctorAvailabilityResponse(
                    doctorId,
                    "Unknown Doctor",
                    false,
                    "Unknown",
                    "Doctor was not found"
            );
        }

        String[] parts = doctorInfo.split(" - ");
        return new DoctorAvailabilityResponse(
                doctorId,
                parts[0],
                true,
                parts[1],
                "Doctor is available"
        );
    }
}
