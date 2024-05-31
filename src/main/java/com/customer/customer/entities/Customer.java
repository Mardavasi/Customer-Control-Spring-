package com.customer.customer.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Esta clase representa la entidad Customer en la base de datos.
 * Contiene información sobre los clientes, como su nombre, apellido, correo electrónico y dirección.
 * Está mapeada a la tabla "customer" en la base de datos y utiliza la anotación @Data de Lombok para generar automáticamente
 * los getters, setters, toString, equals y hashCode.
 */


@Entity
@Data
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
}
