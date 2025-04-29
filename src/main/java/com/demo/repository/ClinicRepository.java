package com.demo.repository;





import com.demo.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    Optional<Clinic> findByEmail(String email);
}
