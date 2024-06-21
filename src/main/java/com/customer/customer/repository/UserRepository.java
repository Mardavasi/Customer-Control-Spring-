package com.customer.customer.repository;

import com.customer.customer.entities.Customer;
import com.customer.customer.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends CrudRepository<Customer,Integer>  {
    //esto es codigo Hql que es el lenguaje  intermediario con sql
    @Query("SELECT c FROM User c WHERE email LIKE  %:email% OR address LIKE %:address%")
    List<User> findByEmailOrAddress(@Param("email") String email, String address);


}

