package in.hostocare.hostocare.appointment.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.hostocare.hostocare.appointment.dto.AppointmentCreateDto;
import in.hostocare.hostocare.appointment.dto.AppointmentResponseDto;
import in.hostocare.hostocare.appointment.entity.Appointment;
import in.hostocare.hostocare.appointment.repository.AppointmentRepository;
import in.hostocare.hostocare.common.kafka.KafkaTopics;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public AppointmentResponseDto bookAppointment(AppointmentCreateDto appointmentCreateDto) {
        // Convert DTO to Entity
        Appointment appointment = Appointment.builder()
                .hospitalId(Long.parseLong(appointmentCreateDto.getHospitalId()))
                .doctorId(Long.parseLong(appointmentCreateDto.getDocterId()))
                .patientId(Long.parseLong(appointmentCreateDto.getPatientId()))
                .appointmentStart(appointmentCreateDto.getAppointmentStartTime())
                .appointmentEnd(appointmentCreateDto.getAppointmentEndTime())
                .createdAt(Instant.now())
                .build();

        // Save appointment
        Appointment savedAppointment = appointmentRepository.save(appointment);

        // Publish Kafka event for appointment created
        kafkaTemplate.send(KafkaTopics.APPOINTMENT_CREATED, savedAppointment);

        // Convert Entity to Response DTO
        return AppointmentResponseDto.builder()
                .appointmentId(savedAppointment.getAppointmentId())
                .hospitalId(savedAppointment.getHospitalId())
                .doctorId(savedAppointment.getDoctorId())
                .patientId(savedAppointment.getPatientId())
                .appointmentStart(savedAppointment.getAppointmentStart())
                .appointmentEnd(savedAppointment.getAppointmentEnd())
                .createdAt(savedAppointment.getCreatedAt())
                .build();
    }
}
