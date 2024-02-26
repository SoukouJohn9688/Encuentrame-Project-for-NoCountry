package com.encuentrame.project.encuentrame.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/caregiver") //localhost:8080/caregiver
public class CareGiverController {

    @GetMapping("/find") //localhost:8080/caregiver/register
    public String findCaregiver(){
        return "<p>Milkshake Proteínas ¿Sube escalones? Distintas Medidas \n" +
                "= Lleno Esfuerzo Llena Foco Láser ahora mucho mejor \n" +
                "que estoy arriba Brillo Tripas Abrir Tripas Shiny \n" +
                "Cuidados clavar los dientes en cada Órgano + Testing \n" +
                "diferentes texturas & aromatic Adventures / Full media \n" +
                "Asta > Full Vaso Medio lleno Cobre Lleno Medium \n" +
                "Weight Champion + Sabiduría (¿tekowe?) Busca 3 busca \n" +
                "4 & 5 Interlaudem; No carnes No abejorros En \n" +
                "Primavera Full Strobe Epileptic Journey + Hace falta</p>";
    }


}
