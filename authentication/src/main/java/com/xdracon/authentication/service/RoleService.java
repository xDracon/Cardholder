package com.xdracon.authentication.service;

import lombok.RequiredArgsConstructor;
import com.xdracon.authentication.entities.Role;
import org.springframework.stereotype.Service;
import com.xdracon.authentication.repositories.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}
