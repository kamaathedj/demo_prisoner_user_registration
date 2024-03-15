package com.example.demo;

import com.example.demo.warden.Warden;
import com.example.demo.warden.WardenRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

@Bean
    ApplicationListener<ApplicationReadyEvent> listener(WardenRepository repo, PasswordEncoder encoder){
        return event -> {

            repo.save(new Warden(1, "admin", encoder.encode("1234"), 400, true));
        };
}

}
