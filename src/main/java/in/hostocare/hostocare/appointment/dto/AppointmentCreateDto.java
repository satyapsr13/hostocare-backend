package in.hostocare.hostocare.appointment.dto;

import java.time.Instant;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentCreateDto {
    @NotBlank(message = "docterId is required")
    private String docterId;

    @NotBlank(message = "patientId is required")
    private String patientId;

    @NotBlank(message = "hospital is required")
    private String hospitalId;

    private Instant appointmentStartTime;
    private Instant appointmentEndTime;

}
