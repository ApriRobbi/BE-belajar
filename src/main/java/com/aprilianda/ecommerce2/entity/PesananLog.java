package com.aprilianda.ecommerce2.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// ini dibuat supaya selalu ada log disetiap terjadinya perubahan
@Entity
@Data
public class PesananLog implements Serializable {
    @Id
    private String id;
    // dilakukan join : pesanan yang mana?
    @JoinColumn
    @ManyToOne
    private Pesanan pesanan;

    //siapa yang melakukan
    @JoinColumn
    @ManyToOne
    private Pengguna pengguna;

    //jenis log
    private Integer logType;
    private String logMessage;

    //kapan terjadinya
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktu;

}
