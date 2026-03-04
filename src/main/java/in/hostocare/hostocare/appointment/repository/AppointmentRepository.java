package in.hostocare.hostocare.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.hostocare.hostocare.appointment.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
