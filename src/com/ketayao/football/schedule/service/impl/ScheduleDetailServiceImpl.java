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
import com.ketayao.football.schedule.entity.ScheduleDetail;
import com.ketayao.football.schedule.dao.ScheduleDetailDAO;
import com.ketayao.football.schedule.service.ScheduleDetailService;

@Service
@Transactional
public class ScheduleDetailServiceImpl implements ScheduleDetailService {
	
	@Autowired
	private ScheduleDetailDAO scheduleDetailDAO;

	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.schedule.service.ScheduleDetailService#get(java.lang.Long)  
	 */ 
	@Override
	public ScheduleDetail get(Long id) {
		return scheduleDetailDAO.findOne(id);
	}

	/*
	 * (non-Javadoc) 
	 * @see com.ketayao.football.schedule.service.ScheduleDetailService#saveOrUpdate(com.ketayao.football.schedule.entity.ScheduleDetail)  
	 */
	@Override
	public void saveOrUpdate(ScheduleDetail scheduleDetail) {
		scheduleDetailDAO.save(scheduleDetail);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.schedule.service.ScheduleDetailService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(Long id) {
		scheduleDetailDAO.delete(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.schedule.service.ScheduleDetailService#findAll(com.ketayao.ketacustom.util.dwz.Page)  
	 */
	@Override
	public List<ScheduleDetail> findAll(Page page) {
		org.springframework.data.domain.Page<ScheduleDetail> springDataPage = scheduleDetailDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.schedule.service.ScheduleDetailService#findByExample(org.springframework.data.jpa.domain.Specification, com.ketayao.ketacustom.util.dwz.Page)	
	 */
	@Override
	public List<ScheduleDetail> findByExample(
			Specification<ScheduleDetail> specification, Page page) {
		org.springframework.data.domain.Page<ScheduleDetail> springDataPage = scheduleDetailDAO.findAll(specification, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
}
