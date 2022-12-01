package com.aprilianda.ecommerce2.repository;

import com.aprilianda.ecommerce2.entity.Produk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdukRepository extends JpaRepository<Produk, String>  {
}
