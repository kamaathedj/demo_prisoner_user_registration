package com.example.demo.warden;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WardenController {
    private final WardenService wardenService;

    public WardenController(WardenService wardenService) {
        this.wardenService = wardenService;
    }
    @GetMapping("/create")
    public String createWarden(){
        return wardenService.createWarden().orElseThrow();
    }
}
