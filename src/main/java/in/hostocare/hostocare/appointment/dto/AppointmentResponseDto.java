package in.hostocare.hostocare.appointment.dto;

import java.time.Instant;

import in.hostocare.hostocare.appointment.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponseDto {
    private Long appointmentId;
    private Long hospitalId;
    private Long doctorId;
    private Long patientId;
    private Instant appointmentStart;
    private Instant appointmentEnd;
    private Instant createdAt;

    
}
