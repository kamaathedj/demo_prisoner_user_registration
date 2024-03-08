package com.example.demo.warden;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WardenRepository extends JpaRepository<Warden, Integer> {
    @Query(
            """
                    SELECT w FROM Warden w where w.name=:name
                    """
    )
    Optional<Warden> findByName(String name);
}
