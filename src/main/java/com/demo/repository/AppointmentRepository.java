package com.demo.repository;



import com.demo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientEmail(String email);
    List<Appointment> findBySlotClinicId(Long clinicId);
}
