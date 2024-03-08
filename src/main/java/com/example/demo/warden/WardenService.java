package com.example.demo.warden;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WardenService {
    private final WardenRepository wardenRepository;

    public WardenService(WardenRepository wardenRepository) {
        this.wardenRepository = wardenRepository;
    }

    public Optional<String> createWarden(){
        return Optional.of("created");
    }
    public Optional<List<Warden>> getWardens(){
        return Optional.of(wardenRepository.findAll());
    }
}
