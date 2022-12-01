package com.aprilianda.ecommerce2.service;

import com.aprilianda.ecommerce2.entity.Pengguna;
import com.aprilianda.ecommerce2.exception.BadRequestException;
import com.aprilianda.ecommerce2.exception.ResourceNotFoundException;
import com.aprilianda.ecommerce2.repository.PenggunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PenggunaService {
    @Autowired
    private PenggunaRepository penggunaRepository;

    public Pengguna findById(String id) {
        return penggunaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pengguna dengan id" + id + "TIDAK DITEMUKAN"));
    }

    public List<Pengguna> findAll(){
        return penggunaRepository.findAll();
    }

    public Pengguna create(Pengguna pengguna){
        // validasi bahwa id menjadi username tidak null
        if (!StringUtils.hasText(pengguna.getId())){
            throw new BadRequestException("Username Harus Diisi");
        }

        // validasi apakah username sudah ada atau belum
        if (penggunaRepository.existsById(pengguna.getId())){
            throw new BadRequestException("Username " + pengguna.getId() + " Sudah Terdaftar");
        }

        // validasi email, harus diisi
        if (!StringUtils.hasText(pengguna.getEmail())){
            throw new BadRequestException("Email Harus Diisi");
        }

        // validasi apakah email sudah terdaftar, dan sekalian membuat method karena existsByEmail belum ada methodnya
        // maka buat methodnya di PenggunaRepository
        if (penggunaRepository.existsByEmail(pengguna.getEmail())){
            throw new BadRequestException("Email " + pengguna.getEmail() + " Sudah Terdaftar");
        }

        pengguna.setIsAktif(true);

        return penggunaRepository.save(pengguna);
    }

    public Pengguna edit(Pengguna pengguna){
        // validasi bahwa id menjadi username tidak null
        if (!StringUtils.hasText(pengguna.getId())){
            throw new BadRequestException("Username Harus Diisi");
        }

        // validasi email, harus diisi
        if (!StringUtils.hasText(pengguna.getEmail())){
            throw new BadRequestException("Email Harus Diisi");
        }

        return penggunaRepository.save(pengguna);
    }

    public void deleteById(String id){
        penggunaRepository.deleteById(id);
    }
}
