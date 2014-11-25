/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.level.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.ketayao.football.level.entity.Level;
import com.ketayao.ketacustom.util.dwz.Page;

public interface LevelService {
	Level get(Long id);

	void saveOrUpdate(Level level);

	void delete(Long id);
	
	List<Level> findAll(Page page);
	
	List<Level> findByExample(Specification<Level> specification, Page page);
}
