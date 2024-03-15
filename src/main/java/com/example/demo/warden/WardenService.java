package com.example.demo.warden;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WardenService {
    private final WardenRepository wardenRepository;

    public WardenService(WardenRepository wardenRepository) {
        this.wardenRepository = wardenRepository;
    }
    @PreAuthorize("hasAnyAuthority()")
    public Optional<String> createWarden() {
        return Optional.of("created");
    }
    @PreAuthorize("hasAuthority('read')")
    public  Optional<List<Warden>> getWardens(){
        return Optional.of(wardenRepository.findAll());
    }

    public Optional<Warden> getWardenByName(String name){
        return wardenRepository.findByName(name);
    }
}
