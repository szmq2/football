/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.team.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ketayao.football.team.entity.Team;


public interface TeamDAO extends JpaRepository<Team, Long>, JpaSpecificationExecutor<Team> {

}