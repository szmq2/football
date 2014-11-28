/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package	com.ketayao.football.schedule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ketayao.ketacustom.util.dwz.Page;
import com.ketayao.ketacustom.util.dwz.PageUtils;
import com.ketayao.football.schedule.entity.Schedule;
import com.ketayao.football.schedule.dao.ScheduleDAO;
import com.ketayao.football.schedule.service.ScheduleService;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleDAO scheduleDAO;

	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.schedule.service.ScheduleService#get(java.lang.Long)  
	 */ 
	@Override
	public Schedule get(Long id) {
		return scheduleDAO.findOne(id);
	}

	/*
	 * (non-Javadoc) 
	 * @see com.ketayao.football.schedule.service.ScheduleService#saveOrUpdate(com.ketayao.football.schedule.entity.Schedule)  
	 */
	@Override
	public void saveOrUpdate(Schedule schedule) {
		scheduleDAO.save(schedule);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.schedule.service.ScheduleService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(Long id) {
		scheduleDAO.delete(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.schedule.service.ScheduleService#findAll(com.ketayao.ketacustom.util.dwz.Page)  
	 */
	@Override
	public List<Schedule> findAll(Page page) {
		org.springframework.data.domain.Page<Schedule> springDataPage = scheduleDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.schedule.service.ScheduleService#findByExample(org.springframework.data.jpa.domain.Specification, com.ketayao.ketacustom.util.dwz.Page)	
	 */
	@Override
	public List<Schedule> findByExample(
			Specification<Schedule> specification, Page page) {
		org.springframework.data.domain.Page<Schedule> springDataPage = scheduleDAO.findAll(specification, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
}
