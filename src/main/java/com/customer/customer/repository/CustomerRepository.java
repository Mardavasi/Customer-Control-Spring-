package com.customer.customer.repository;

import com.customer.customer.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Esta interfaz define métodos para acceder y manipular datos relacionados con clientes en la base de datos.
 * Extiende CrudRepository, proporcionando métodos CRUD básicos, y además incluye consultas personalizadas utilizando HQL (Hibernate Query Language).
 */

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    //esto es codigo Hql que es el lenguaje  intermediario con sql
    @Query("SELECT c FROM Customer c WHERE email LIKE  %:email% OR address LIKE %:address%")
    List<Customer> findByEmailOrAddress(@Param("email") String email, String address);
}
