package com.aprilianda.ecommerce2.entity;

import com.aprilianda.ecommerce2.model.StatusPesanan;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Pesanan implements Serializable {

    @Id
    private String id;
    private String nomorPesanan;
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @JoinColumn
    @ManyToOne
    private Pengguna pengguna;
    private String alamatPengiriman;
    private BigDecimal jumlahTransaksi;
    private BigDecimal ongkosKirim;
    private BigDecimal totalPesanan;
    //karena status sifatnya fix, maka ada draf proses packing dan selesai maka dibuat enum saja
    @Enumerated(EnumType.STRING)
    private StatusPesanan statusPesanan;

    //dibuat untuk membuat pengurutan waktu pesan
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuPesan;

}
