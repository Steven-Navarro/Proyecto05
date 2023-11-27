package com.bbva.MicroservicePurchasing.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
@Entity
@Table(name = "compras")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompra;
    private Date fecha;
    private BigDecimal montoTotal;

}
