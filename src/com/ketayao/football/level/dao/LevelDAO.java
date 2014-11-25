/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.level.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ketayao.football.level.entity.Level;

public interface LevelDAO extends JpaRepository<Level, Long>, JpaSpecificationExecutor<Level> {

}