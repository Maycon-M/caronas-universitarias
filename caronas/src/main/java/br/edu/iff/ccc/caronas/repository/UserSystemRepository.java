package br.edu.iff.ccc.caronas.repository;

import br.edu.iff.ccc.caronas.entities.UserSystem;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSystemRepository extends JpaRepository<UserSystem, Long> {
    Optional<UserSystem> findByEmail(String email);
    boolean existsByEmail(String email);
}
