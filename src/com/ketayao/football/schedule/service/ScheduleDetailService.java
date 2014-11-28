/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.schedule.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.ketayao.football.schedule.entity.ScheduleDetail;
import com.ketayao.ketacustom.util.dwz.Page;

public interface ScheduleDetailService {
	ScheduleDetail get(Long id);

	void saveOrUpdate(ScheduleDetail scheduleDetail);

	void delete(Long id);
	
	List<ScheduleDetail> findAll(Page page);
	
	List<ScheduleDetail> findByExample(Specification<ScheduleDetail> specification, Page page);
}
