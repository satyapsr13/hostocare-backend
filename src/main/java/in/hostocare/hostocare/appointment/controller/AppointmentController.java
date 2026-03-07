package in.hostocare.hostocare.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.hostocare.hostocare.appointment.dto.AppointmentCreateDto;
import in.hostocare.hostocare.appointment.dto.AppointmentResponseDto;
import in.hostocare.hostocare.appointment.service.AppointmentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/appointment/")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("book")
    public ResponseEntity<AppointmentResponseDto> bookAppointment(
            @Valid @RequestBody AppointmentCreateDto appointmentCreateDto) {
        AppointmentResponseDto response = appointmentService.bookAppointment(appointmentCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("list")
    public ResponseEntity<Object> getAppointments(in.hostocare.hostocare.appointment.dto.AppointmentFilterDto filter) {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getAppointments(filter));
    }

    @GetMapping()
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello world");
    }

}
