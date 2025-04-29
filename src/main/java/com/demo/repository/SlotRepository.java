package com.demo.repository;


import com.demo.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findByDateAndIsAvailable(LocalDate date, boolean isAvailable);
    List<Slot> findByClinicId(Long clinicId);
}
