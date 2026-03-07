package in.hostocare.hostocare.appointment.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentFilterDto {
    private Long hospitalId;
    private Long doctorId;
    private Long patientId;
    private Instant startDate;
    private Instant endDate;
}
