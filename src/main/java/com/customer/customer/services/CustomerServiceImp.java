package com.customer.customer.services;

import com.customer.customer.entities.Customer;
import com.customer.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Esta clase implementa la interfaz CustomerService y proporciona la lógica para realizar operaciones relacionadas con clientes.
 * Los métodos implementados permiten acceder a la información de los clientes, agregar nuevos clientes, actualizar y eliminar clientes,
 * así como buscar clientes por correo electrónico y dirección.
 */

@Service
public class CustomerServiceImp {

    @Autowired
    private CustomerRepository repository;


    public Customer getCustomer(Integer id) {
        Optional<Customer> customer = repository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        return null;
    }


    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        Iterable<Customer> customers = repository.findAll();
        for (Customer customer : customers) {
            list.add(customer);

        }
        return list;
    }

    public void deleteCustomer(Integer id) {
        repository.deleteById(id);


    }

    public void addCustomer(Customer customer) {
        repository.save(customer);


    }

    public void updateCustomer(Integer id, Customer updateCustomer) {
        updateCustomer.setId(id);
        repository.save(updateCustomer);


    }

    public List<Customer> searchCustomer(String email, String address) {
        return repository.findByEmailOrAddress(email, address);
    }
}
