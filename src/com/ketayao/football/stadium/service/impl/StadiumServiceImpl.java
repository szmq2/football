/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package	com.ketayao.football.stadium.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ketayao.ketacustom.util.dwz.Page;
import com.ketayao.ketacustom.util.dwz.PageUtils;
import com.ketayao.football.stadium.entity.Stadium;
import com.ketayao.football.stadium.dao.StadiumDAO;
import com.ketayao.football.stadium.service.StadiumService;

@Service
@Transactional
public class StadiumServiceImpl implements StadiumService {
	
	@Autowired
	private StadiumDAO stadiumDAO;

	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.stadium.service.StadiumService#get(java.lang.Long)  
	 */ 
	@Override
	public Stadium get(Long id) {
		return stadiumDAO.findOne(id);
	}

	/*
	 * (non-Javadoc) 
	 * @see com.ketayao.football.stadium.service.StadiumService#saveOrUpdate(com.ketayao.football.stadium.entity.Stadium)  
	 */
	@Override
	public void saveOrUpdate(Stadium stadium) {
		stadiumDAO.save(stadium);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.stadium.service.StadiumService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(Long id) {
		stadiumDAO.delete(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.stadium.service.StadiumService#findAll(com.ketayao.ketacustom.util.dwz.Page)  
	 */
	@Override
	public List<Stadium> findAll(Page page) {
		org.springframework.data.domain.Page<Stadium> springDataPage = stadiumDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.stadium.service.StadiumService#findByExample(org.springframework.data.jpa.domain.Specification, com.ketayao.ketacustom.util.dwz.Page)	
	 */
	@Override
	public List<Stadium> findByExample(
			Specification<Stadium> specification, Page page) {
		org.springframework.data.domain.Page<Stadium> springDataPage = stadiumDAO.findAll(specification, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
}
