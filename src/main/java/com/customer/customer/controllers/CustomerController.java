package com.customer.customer.controllers;
import com.customer.customer.entities.Customer;
import com.customer.customer.services.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Esta clase actúa como el controlador principal para manejar las solicitudes relacionadas con la gestión de clientes.
 * Proporciona puntos de entrada para agregar, actualizar, eliminar y recuperar información de clientes.
 * Se comunica con el servicio CustomerService para realizar operaciones en la capa de negocio.
 */

@RestController

@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerServiceImp service;


    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        return service.getCustomer(id);


    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomer() {
        return service.getAllCustomers();
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
    }

    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);

    }

    @PutMapping("/customer/{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody Customer updateCustomer) {
        service.updateCustomer(id, updateCustomer);

    }

    @GetMapping("/customer/search")
    public List<Customer> searchCustomer(@RequestParam(name = "email", required = false) String email,
                                         @RequestParam(name = "address", required = false) String address) {
        return service.searchCustomer(email, address);


    }
}
