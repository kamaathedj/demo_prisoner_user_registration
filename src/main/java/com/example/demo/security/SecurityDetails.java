package com.example.demo.security;

import com.example.demo.warden.Warden;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityDetails implements UserDetails {
    private final Warden warden;

    public SecurityDetails(Warden warden) {
        this.warden = warden;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(warden.isIs_admin()){
            return List.of(()->"write");
        }
        return List.of(()->"read");
    }

    @Override
    public String getPassword() {

        return warden.getPassword();
    }

    @Override
    public String getUsername() {
        return warden.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
