package com.codegym.penzuproject.service.Impl;

import com.codegym.penzuproject.model.Role;
import com.codegym.penzuproject.model.RoleName;
import com.codegym.penzuproject.repository.IRoleRepository;
import com.codegym.penzuproject.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository repository;

    @Override
    public Optional<Role> findByName(RoleName roleName) {
        return repository.findByName(roleName);
    }
}
