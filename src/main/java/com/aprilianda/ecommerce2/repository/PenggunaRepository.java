package com.aprilianda.ecommerce2.repository;


import com.aprilianda.ecommerce2.entity.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenggunaRepository extends JpaRepository<Pengguna, String> {
    boolean existsByEmail(String email);
}
