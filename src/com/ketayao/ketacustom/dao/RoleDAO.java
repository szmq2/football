/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.ketacustom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ketayao.ketacustom.entity.main.Role;

public interface RoleDAO extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

}