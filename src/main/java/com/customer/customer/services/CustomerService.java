package com.customer.customer.services;

import com.customer.customer.entities.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Esta interfaz define los métodos necesarios para realizar operaciones relacionadas con clientes.
 * Los métodos permiten acceder a la información de los clientes, agregar nuevos clientes, actualizar y eliminar clientes,
 * así como buscar clientes por correo electrónico y dirección.
 */
public interface CustomerService {

    Customer getCustomer(Integer id);
    List<Customer> getAllCustomers();
    void deleteCustomer(Integer id);
    void addCustomer(Customer customer);
    void updateCustomer(Integer id, Customer updateCustomer);
    List<Customer> searchCustomer(String email, String address);
}
