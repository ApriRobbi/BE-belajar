package com.aprilianda.ecommerce2.service;

import com.aprilianda.ecommerce2.entity.Kategori;
import com.aprilianda.ecommerce2.exception.ResourceNotFoundException;
import com.aprilianda.ecommerce2.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KategoriService {
    @Autowired
    private KategoriRepository kategoriRepository;

    public Kategori findById(String id) {
        return kategoriRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kategori dengan id" + id + "TIDAK DITEMUKAN"));
    }

    public List<Kategori> findAll(){
        return kategoriRepository.findAll();
    }

    public Kategori create(Kategori kategori){
        kategori.setId(UUID.randomUUID().toString());
        return kategoriRepository.save(kategori);
    }

    public Kategori edit(Kategori kategori){
        return kategoriRepository.save(kategori);
    }

    public void deleteById(String id){
        kategoriRepository.deleteById(id);
    }
}
