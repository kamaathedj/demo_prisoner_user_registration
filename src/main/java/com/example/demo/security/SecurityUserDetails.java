package com.example.demo.security;

import com.example.demo.warden.WardenRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@Configuration
public class SecurityUserDetails implements UserDetailsService {
    private final WardenRepository wardenRepository;

    public SecurityUserDetails(WardenRepository wardenRepository) {
        this.wardenRepository = wardenRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        var user = wardenRepository.findByName(username);
        return user.map(SecurityDetails::new).orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}
