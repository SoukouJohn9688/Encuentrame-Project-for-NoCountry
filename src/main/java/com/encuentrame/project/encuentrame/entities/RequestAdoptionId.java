package com.encuentrame.project.encuentrame.entities;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestAdoptionId implements Serializable {

    private User user;

    private Pet pet;

}