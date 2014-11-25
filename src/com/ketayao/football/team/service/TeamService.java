/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.team.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.ketayao.football.team.entity.Team;
import com.ketayao.ketacustom.util.dwz.Page;

public interface TeamService {
	Team get(Long id);

	void saveOrUpdate(Team team);

	void delete(Long id);

	List<Team> findAll(Page page);

	List<Team> findByExample(Specification<Team> specification, Page page);
}
