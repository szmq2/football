/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package	com.ketayao.football.team.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ketayao.football.team.dao.TeamDAO;
import com.ketayao.football.team.entity.Team;
import com.ketayao.football.team.service.TeamService;
import com.ketayao.ketacustom.util.dwz.Page;
import com.ketayao.ketacustom.util.dwz.PageUtils;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	private TeamDAO teamDAO;

	/*
	 * (non-Javadoc)
	 * @see com.football.team.service.TeamService#get(java.lang.Long)  
	 */ 
	@Override
	public Team get(Long id) {
		return teamDAO.findOne(id);
	}

	/*
	 * (non-Javadoc) 
	 * @see com.football.team.service.TeamService#saveOrUpdate(com.football.team.entity.Team)  
	 */
	@Override
	public void saveOrUpdate(Team team) {
		teamDAO.save(team);
	}

	/*
	 * (non-Javadoc)
	 * @see com.football.team.service.TeamService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(Long id) {
		teamDAO.delete(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.football.team.service.TeamService#findAll(com.ketayao.ketacustom.util.dwz.Page)  
	 */
	@Override
	public List<Team> findAll(Page page) {
		org.springframework.data.domain.Page<Team> springDataPage = teamDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.football.team.service.TeamService#findByExample(org.springframework.data.jpa.domain.Specification, com.ketayao.ketacustom.util.dwz.Page)	
	 */
	@Override
	public List<Team> findByExample(
			Specification<Team> specification, Page page) {
		org.springframework.data.domain.Page<Team> springDataPage = teamDAO.findAll(specification, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
}
