package com.kovbel.agency.repository;


import com.kovbel.agency.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String userName);
}