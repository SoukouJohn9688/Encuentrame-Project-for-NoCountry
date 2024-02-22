package com.encuentrame.project.encuentrame.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.math.BigDecimal;


@Entity
@Table(name = "donaciones_historico")

public class Donations {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_donante")
    private String nombreDonante;
    @Column(name = "email_donante")
    private String emailDonante;
    @Enumerated(EnumType.STRING)
    @Column(name = "medio_pago")
    private MedioPago medioPago;
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "fecha_hora", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date fechaHora;

    public Donations() {
    }

    enum MedioPago {
        Credito,
        Debito,
        Transferencia
    }
}
