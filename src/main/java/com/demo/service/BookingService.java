package com.demo.service;



import com.demo.dto.BookingRequest;
import com.demo.entity.*;
import com.demo.repository.AppointmentRepository;
import com.demo.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private EmailService emailService;

    public Appointment bookAppointment(BookingRequest request) {
        Slot slot = slotRepository.findById(request.getSlotId())
                .orElseThrow(() -> new RuntimeException("Créneau non trouvé"));

        Appointment appointment = new Appointment();
        appointment.setPatientName(request.getPatientName());
        appointment.setPatientEmail(request.getPatientEmail());
        appointment.setPatientPhone(request.getPatientPhone());
        appointment.setSlot(slot);
        appointment.setStatus(Status.PENDING);

        emailService.sendAppointmentConfirmation(
            request.getPatientEmail(),
            request.getPatientName(),
            slot.getDate() + " à " + slot.getStartTime()
        );

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getPatientAppointments(String email) {
        return appointmentRepository.findByPatientEmail(email);
    }
}
