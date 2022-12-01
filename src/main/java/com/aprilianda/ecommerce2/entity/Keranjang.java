package com.aprilianda.ecommerce2.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// masih temporari belom berupa pesanan
@Entity
@Data
public class Keranjang implements Serializable {

    @Id
    private String id;

    //produk yang mana? makanya dilakukan join
    @JoinColumn
    @ManyToOne
    private Produk produk;

    // pengguna yang mana? maka dilakukan JOIN
    @JoinColumn
    @ManyToOne
    private Pengguna pengguna;

    private Double kuantitas;

    private BigDecimal hargaSatuan;

    private BigDecimal jumlah;

    // mencatat waktu dibuat
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuDibuat;
}
