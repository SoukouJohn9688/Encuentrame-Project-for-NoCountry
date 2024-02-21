package com.encuentrame.project.encuentrame.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private enum especie{
        perro,
        gato

    };

    private String raza;
    private  Integer edad_meses;
    private String color;
    private enum tamaño{
        chico,
        mediano,
        grande
    }

    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_careGiver", nullable = false)
    private CareGiver careGiver;
        private boolean adoptado;



}
