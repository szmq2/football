/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.team.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ketayao.football.team.entity.Team;
import com.ketayao.football.team.service.TeamService;
import com.ketayao.ketacustom.log.Log;
import com.ketayao.ketacustom.log.LogMessageObject;
import com.ketayao.ketacustom.log.impl.LogUitls;
import com.ketayao.ketacustom.util.dwz.AjaxObject;
import com.ketayao.ketacustom.util.dwz.Page;
import com.ketayao.ketacustom.util.persistence.DynamicSpecifications;

@Controller
@RequestMapping("/web/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	private static final String ADD = "/web/team/add";
	private static final String CREATE = "management/web/team/create";
	private static final String UPDATE = "management/web/team/update";
	private static final String LIST = "management/web/team/list";
	private static final String VIEW = "management/web/team/view";
	
	@InitBinder
	public void dataBinder(WebDataBinder dataBinder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(df, true));
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String showAdd() {
		return ADD;
	}
	
	@RequiresPermissions("Team:save")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String preCreate(Map<String, Object> map) {
		return CREATE;
	}
	
	@Log(message="添加了id={0}队伍。")
	@RequiresPermissions("Team:save")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String create(@Valid Team team) {
		teamService.saveOrUpdate(team);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{team.getId()}));
		return AjaxObject.newOk("队伍添加成功！").toString();
	}
	
	@ModelAttribute("preloadTeam")
	public Team preload(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			Team team = teamService.get(id);
			return team;
		}
		return null;
	}
	
	@RequiresPermissions("Team:edit")
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		Team team = teamService.get(id);
		map.put("team", team);
		return UPDATE;
	}
	
	@Log(message="修改了id={0}队伍的信息。")
	@RequiresPermissions("Team:edit")
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String update(@Valid @ModelAttribute("preloadTeam")Team team) {
		teamService.saveOrUpdate(team);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{team.getId()}));
		return AjaxObject.newOk("队伍修改成功！").toString();
	}

	@Log(message="删除了id={0}队伍。")
	@RequiresPermissions("Team:delete")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable Long id) {
		teamService.delete(id);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{id}));
		return AjaxObject.newOk("队伍删除成功！").setCallbackType("").toString();
	}
	
	@Log(message="批量删除了id={0}队伍。")
	@RequiresPermissions("Team:delete")
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody String deleteMany(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Team team = teamService.get(ids[i]);
			teamService.delete(team.getId());
		}
		
		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{Arrays.toString(ids)}));
		return AjaxObject.newOk("队伍删除成功！").setCallbackType("").toString();
	}

	@RequiresPermissions("Team:view")
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(ServletRequest request, Page page, Map<String, Object> map) {
		Specification<Team> specification = DynamicSpecifications.bySearchFilter(request, Team.class);
		List<Team> teams = teamService.findByExample(specification, page);
		
		map.put("page", page);
		map.put("teams", teams);

		return LIST;
	}
	
	@RequiresPermissions("Team:view")
	@RequestMapping(value="/view/{id}", method={RequestMethod.GET})
	public String view(@PathVariable Long id, Map<String, Object> map) {
		Team team = teamService.get(id);
		map.put("team", team);
		return VIEW;
	}
}
