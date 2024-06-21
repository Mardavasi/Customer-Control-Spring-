package com.customer.customer.services;

import com.customer.customer.entities.User;
import com.customer.customer.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Esta clase implementa la interfaz UserService y proporciona la lógica para realizar operaciones relacionadas con clientes.
 * Los métodos implementados permiten acceder a la información de los clientes, agregar nuevos clientes, actualizar y eliminar clientes,
 * así como buscar clientes por correo electrónico y dirección.
 */

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository repository;

    private static final String SECRET_KEY ="j64ydu29ed";


    public User getUser(Integer id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }


    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        Iterable<User> users = repository.findAll();
        for (User user : users) {
            list.add(user);

        }
        return list;
    }

    public void deleteUser(Integer id) {
        repository.deleteById(id);


    }

    public void addUser(User user) {
        String hashPassword = Hashing.sha256()
                        .hashString(user.getPassword() +  SECRET_KEY, StandardCharsets.UTF_8)
                                .toString();
        user.setPassword(hashPassword);
        repository.save(user);


    }

    public void updateUser(Integer id, User updateUser) {
        updateUser.setId(id);
        repository.save(updateUser);


    }

    public List<User> searchUser(String email, String address) {
        return repository.findByEmailOrAddress(email, address);
    }
}