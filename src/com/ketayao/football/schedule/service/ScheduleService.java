/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.schedule.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.ketayao.football.schedule.entity.Schedule;
import com.ketayao.ketacustom.util.dwz.Page;

public interface ScheduleService {
	Schedule get(Long id);

	void saveOrUpdate(Schedule schedule);

	void delete(Long id);
	
	List<Schedule> findAll(Page page);
	
	List<Schedule> findByExample(Specification<Schedule> specification, Page page);
}
