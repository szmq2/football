/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.stadium.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ketayao.football.stadium.entity.Stadium;

public interface StadiumDAO extends JpaRepository<Stadium, Long>, JpaSpecificationExecutor<Stadium> {

}