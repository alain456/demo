package com.demo.service;



import com.demo.dto.SlotDto;
import com.demo.entity.Clinic;
import com.demo.entity.Slot;
import com.demo.repository.ClinicRepository;
import com.demo.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService implements UserDetailsService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) clinicRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Clinique non trouvée"));
    }

    public Slot addSlot(SlotDto slotDto) {
        // Implémentation à compléter avec la clinique connectée
        Slot slot = new Slot();
        slot.setDate(slotDto.getDate());
        slot.setStartTime(slotDto.getStartTime());
        slot.setEndTime(slotDto.getEndTime());
        return slotRepository.save(slot);
    }

    public List<Slot> getClinicSlots() {
        // Implémentation à compléter
        return slotRepository.findAll();
    }
}