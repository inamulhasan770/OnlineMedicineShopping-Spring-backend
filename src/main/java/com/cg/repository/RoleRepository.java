package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>
{

}
