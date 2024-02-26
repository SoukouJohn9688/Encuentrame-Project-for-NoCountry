package com.encuentrame.project.encuentrame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;




import com.encuentrame.project.encuentrame.enumerations.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.math.BigDecimal;

    @Data
    @AllArgsConstructor

    @Entity
    @Table(name = "donaciones_historico")

    public class Donations {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name_donante")
        private String nameDonante;
        @Column(name = "email_donante")
        private String emailDonante;
        @Enumerated(EnumType.STRING)
        @Column(name = "medio_pago")
        private PaymentMethod medioPago;
        @Column(name = "monto")
        private BigDecimal monto;
        @Column(name = "fecha_hora", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
        private Date fechaHora;

        public Donations() {
        }


    }

