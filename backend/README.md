# Medinovaa Backend Microservices

This backend implements the first phase of the Hospital Management System using two collaborating Spring Boot microservices.

## Services

### 1. Doctor Service
- Port: 8082
- Endpoint: `GET /doctors/{doctorId}/availability`
- Responsibility: checks if a doctor exists and is available.

### 2. Appointment Service
- Port: 8081
- Endpoint: `POST /appointments`
- Responsibility: creates an appointment after calling Doctor Service through REST.

## Communication Style

The collaboration between Appointment Service and Doctor Service uses synchronous REST request-response communication.

## Run the services

Open two terminals.

Terminal 1:

```bash
cd backend/doctor-service
mvn spring-boot:run
```

Terminal 2:

```bash
cd backend/appointment-service
mvn spring-boot:run
```

## Test

```bash
curl -X POST http://localhost:8081/appointments \
  -H "Content-Type: application/json" \
  -d '{
    "patientId": "P456",
    "doctorId": "D101",
    "date": "2026-05-01",
    "reason": "General checkup"
  }'
```

Expected response:

```json
{
  "appointmentId": "generated-id",
  "status": "CONFIRMED",
  "message": "Appointment created successfully for patient P456 on 2026-05-01",
  "doctor": {
    "doctorId": "D101",
    "doctorName": "Dr. Ahmad",
    "available": true,
    "specialization": "Cardiology",
    "message": "Doctor is available"
  }
}
```
