/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package	com.ketayao.football.level.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ketayao.ketacustom.util.dwz.Page;
import com.ketayao.ketacustom.util.dwz.PageUtils;
import com.ketayao.football.level.entity.Level;
import com.ketayao.football.level.dao.LevelDAO;
import com.ketayao.football.level.service.LevelService;

@Service
@Transactional
public class LevelServiceImpl implements LevelService {
	
	@Autowired
	private LevelDAO levelDAO;

	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.level.service.LevelService#get(java.lang.Long)  
	 */ 
	@Override
	public Level get(Long id) {
		return levelDAO.findOne(id);
	}

	/*
	 * (non-Javadoc) 
	 * @see com.ketayao.football.level.service.LevelService#saveOrUpdate(com.ketayao.football.level.entity.Level)  
	 */
	@Override
	public void saveOrUpdate(Level level) {
		levelDAO.save(level);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.level.service.LevelService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(Long id) {
		levelDAO.delete(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.level.service.LevelService#findAll(com.ketayao.ketacustom.util.dwz.Page)  
	 */
	@Override
	public List<Level> findAll(Page page) {
		org.springframework.data.domain.Page<Level> springDataPage = levelDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ketayao.football.level.service.LevelService#findByExample(org.springframework.data.jpa.domain.Specification, com.ketayao.ketacustom.util.dwz.Page)	
	 */
	@Override
	public List<Level> findByExample(
			Specification<Level> specification, Page page) {
		org.springframework.data.domain.Page<Level> springDataPage = levelDAO.findAll(specification, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
}
