package in.hostocare.hostocare.appointment.service;

import java.time.Instant;
import java.util.List;

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
        // kafkaTemplate.send(KafkaTopics.APPOINTMENT_CREATED, savedAppointment);

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

    public List<Appointment> getAppointments(in.hostocare.hostocare.appointment.dto.AppointmentFilterDto filter) {
        org.springframework.data.jpa.domain.Specification<Appointment> spec = (root, query, cb) -> {
            java.util.List<jakarta.persistence.criteria.Predicate> predicates = new java.util.ArrayList<>();
            if (filter.getHospitalId() != null) {
                predicates.add(cb.equal(root.get("hospitalId"), filter.getHospitalId()));
            }
            if (filter.getDoctorId() != null) {
                predicates.add(cb.equal(root.get("doctorId"), filter.getDoctorId()));
            }
            if (filter.getPatientId() != null) {
                predicates.add(cb.equal(root.get("patientId"), filter.getPatientId()));
            }
            if (filter.getStartDate() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("appointmentStart"), filter.getStartDate()));
            }
            if (filter.getEndDate() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("appointmentEnd"), filter.getEndDate()));
            }
            return cb.and(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));
        };

        return appointmentRepository.findAll(spec);
    }
}
