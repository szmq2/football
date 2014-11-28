/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.schedule.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ketayao.ketacustom.util.dwz.AjaxObject;
import com.ketayao.ketacustom.util.dwz.Page;
import com.ketayao.ketacustom.util.persistence.DynamicSpecifications;
import com.ketayao.ketacustom.log.Log;
import com.ketayao.ketacustom.log.LogMessageObject;
import com.ketayao.ketacustom.log.impl.LogUitls;
import com.ketayao.football.schedule.entity.Schedule;
import com.ketayao.football.schedule.service.ScheduleService;

@Controller
@RequestMapping("/management/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	private static final String CREATE = "management/schedule/create";
	private static final String UPDATE = "management/schedule/update";
	private static final String LIST = "management/schedule/list";
	private static final String VIEW = "management/schedule/view";
	
	@InitBinder
	public void dataBinder(WebDataBinder dataBinder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(df, true));
	}
	
	@RequiresPermissions("Schedule:save")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String preCreate(Map<String, Object> map) {
		return CREATE;
	}
	
	@Log(message="添加了id={0}赛程。")
	@RequiresPermissions("Schedule:save")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String create(@Valid Schedule schedule) {
		scheduleService.saveOrUpdate(schedule);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{schedule.getId()}));
		return AjaxObject.newOk("赛程添加成功！").toString();
	}
	
	@ModelAttribute("preloadSchedule")
	public Schedule preload(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			Schedule schedule = scheduleService.get(id);
			return schedule;
		}
		return null;
	}
	
	@RequiresPermissions("Schedule:edit")
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		Schedule schedule = scheduleService.get(id);
		map.put("schedule", schedule);
		return UPDATE;
	}
	
	@Log(message="修改了id={0}赛程的信息。")
	@RequiresPermissions("Schedule:edit")
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String update(@Valid @ModelAttribute("preloadSchedule")Schedule schedule) {
		scheduleService.saveOrUpdate(schedule);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{schedule.getId()}));
		return AjaxObject.newOk("赛程修改成功！").toString();
	}

	@Log(message="删除了id={0}赛程。")
	@RequiresPermissions("Schedule:delete")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable Long id) {
		scheduleService.delete(id);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{id}));
		return AjaxObject.newOk("赛程删除成功！").setCallbackType("").toString();
	}
	
	@Log(message="批量删除了id={0}赛程。")
	@RequiresPermissions("Schedule:delete")
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody String deleteMany(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Schedule schedule = scheduleService.get(ids[i]);
			scheduleService.delete(schedule.getId());
		}
		
		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{Arrays.toString(ids)}));
		return AjaxObject.newOk("赛程删除成功！").setCallbackType("").toString();
	}

	@RequiresPermissions("Schedule:view")
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(ServletRequest request, Page page, Map<String, Object> map) {
		Specification<Schedule> specification = DynamicSpecifications.bySearchFilter(request, Schedule.class);
		List<Schedule> schedules = scheduleService.findByExample(specification, page);
		
		map.put("page", page);
		map.put("schedules", schedules);

		return LIST;
	}
	
	@RequiresPermissions("Schedule:view")
	@RequestMapping(value="/view/{id}", method={RequestMethod.GET})
	public String view(@PathVariable Long id, Map<String, Object> map) {
		Schedule schedule = scheduleService.get(id);
		map.put("schedule", schedule);
		return VIEW;
	}
}
