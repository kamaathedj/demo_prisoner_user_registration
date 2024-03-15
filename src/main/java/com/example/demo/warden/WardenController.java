package com.example.demo.warden;


import jakarta.servlet.ServletException;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/user")
    public void getLoggedInUser(){
        System.out.println(AuthenticatedPrincipal.class.getName());

    }

    @GetMapping("/wardens")
    public List<Warden> getWardens(){
        if(wardenService.getWardens().isPresent()){
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            threadLocal.set("david");

            System.out.println(threadLocal.get());
            return wardenService.getWardens().get();

        }else{
            return List.of();
        }
    }

    @GetMapping("/{name}")
    public Warden getWardenByName(@PathVariable String name) throws ServletException {
        Optional<Warden> wardenByName = wardenService.getWardenByName(name);
        return wardenByName.orElseThrow(ServletException::new);
    }

}
