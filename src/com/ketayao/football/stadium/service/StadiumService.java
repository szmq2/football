/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.stadium.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.ketayao.football.stadium.entity.Stadium;
import com.ketayao.ketacustom.util.dwz.Page;

public interface StadiumService {
	Stadium get(Long id);

	void saveOrUpdate(Stadium stadium);

	void delete(Long id);
	
	List<Stadium> findAll(Page page);
	
	List<Stadium> findByExample(Specification<Stadium> specification, Page page);
}
