package com.xdracon.authentication.repositories;

import com.xdracon.authentication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DtoRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}