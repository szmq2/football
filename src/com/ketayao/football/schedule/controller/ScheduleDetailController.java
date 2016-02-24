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
import com.ketayao.ketacustom.util.persistence.SearchFilter;
import com.ketayao.ketacustom.util.persistence.SearchFilter.Operator;
import com.ketayao.ketacustom.log.Log;
import com.ketayao.ketacustom.log.LogMessageObject;
import com.ketayao.ketacustom.log.impl.LogUitls;
import com.ketayao.football.schedule.entity.Schedule;
import com.ketayao.football.schedule.entity.ScheduleDetail;
import com.ketayao.football.schedule.service.ScheduleDetailService;
import com.ketayao.football.schedule.service.ScheduleService;
import com.ketayao.football.stadium.entity.Stadium;
import com.ketayao.football.stadium.service.StadiumService;

@Controller
@RequestMapping("/management/scheduleDetail")
public class ScheduleDetailController {

	@Autowired
	private StadiumService stadiumService;

	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private ScheduleDetailService scheduleDetailService;
	
	private static final String CREATE = "management/scheduleDetail/create";
	private static final String UPDATE = "management/scheduleDetail/update";
	private static final String LIST = "management/scheduleDetail/list";
	private static final String VIEW = "management/scheduleDetail/view";
	
	@InitBinder
	public void dataBinder(WebDataBinder dataBinder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(df, true));
	}
	
	@RequiresPermissions("ScheduleDetail:save")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String preCreate(Long idSchedule, Map<String, Object> map) {
		map.put("idSchedule", idSchedule);
		
		List<Schedule> schedules = scheduleService.findAll(new Page());
		List<Stadium> stadiums = stadiumService.findAll(new Page());
		map.put("schedules", schedules);
		map.put("stadiums", stadiums);
		
		return CREATE;
	}
	
	@Log(message="添加了id={0}赛程明细。")
	@RequiresPermissions("ScheduleDetail:save")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String create(@Valid ScheduleDetail scheduleDetail) {
		scheduleDetailService.saveOrUpdate(scheduleDetail);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{scheduleDetail.getId()}));
		return AjaxObject.newOk("赛程明细添加成功！").toString();
	}
	
	@ModelAttribute("preloadScheduleDetail")
	public ScheduleDetail preload(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			ScheduleDetail scheduleDetail = scheduleDetailService.get(id);
			return scheduleDetail;
		}
		return null;
	}
	
	@RequiresPermissions("ScheduleDetail:edit")
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		ScheduleDetail scheduleDetail = scheduleDetailService.get(id);
		List<Schedule> schedules = scheduleService.findAll(new Page());
		List<Stadium> stadiums = stadiumService.findAll(new Page());
		map.put("schedules", schedules);
		map.put("stadiums", stadiums);
		map.put("scheduleDetail", scheduleDetail);
		return UPDATE;
	}
	
	@Log(message="修改了id={0}赛程明细的信息。")
	@RequiresPermissions("ScheduleDetail:edit")
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String update(@Valid @ModelAttribute("preloadScheduleDetail")ScheduleDetail scheduleDetail) {
		scheduleDetailService.saveOrUpdate(scheduleDetail);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{scheduleDetail.getId()}));
		return AjaxObject.newOk("赛程明细修改成功！").toString();
	}

	@Log(message="删除了id={0}赛程明细。")
	@RequiresPermissions("ScheduleDetail:delete")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable Long id) {
		scheduleDetailService.delete(id);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{id}));
		return AjaxObject.newOk("赛程明细删除成功！").setCallbackType("").toString();
	}
	
	@Log(message="批量删除了id={0}赛程明细。")
	@RequiresPermissions("ScheduleDetail:delete")
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody String deleteMany(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			ScheduleDetail scheduleDetail = scheduleDetailService.get(ids[i]);
			scheduleDetailService.delete(scheduleDetail.getId());
		}
		
		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{Arrays.toString(ids)}));
		return AjaxObject.newOk("赛程明细删除成功！").setCallbackType("").toString();
	}

//	@RequiresPermissions("ScheduleDetail:view")
//	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
//	public String list(ServletRequest request, Page page, Map<String, Object> map) {
//		Specification<ScheduleDetail> specification = DynamicSpecifications.bySearchFilter(request, ScheduleDetail.class);
//		List<ScheduleDetail> scheduleDetails = scheduleDetailService.findByExample(specification, page);
//		
//		map.put("page", page);
//		map.put("scheduleDetails", scheduleDetails);
//
//		return LIST;
//	}
	
	@RequiresPermissions("ScheduleDetail:view")
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Long idSchedule, ServletRequest request, Page page, Map<String, Object> map) {
		Specification<ScheduleDetail> specification = null;
		Schedule schedule = null;
		if (idSchedule == null) {
			specification = DynamicSpecifications.bySearchFilter(request, ScheduleDetail.class);
		} else {
			specification = DynamicSpecifications.bySearchFilter(request, ScheduleDetail.class, new SearchFilter("schedule.id", Operator.EQ, idSchedule));
			schedule = scheduleService.get(idSchedule); 
		}
		
		List<ScheduleDetail> scheduleDetails = scheduleDetailService.findByExample(specification, page);

		
		map.put("page", page);
		map.put("schedule", schedule);
		map.put("scheduleDetails", scheduleDetails);
		
		return LIST;
	}
	
	@RequiresPermissions("ScheduleDetail:view")
	@RequestMapping(value="/view/{id}", method={RequestMethod.GET})
	public String view(@PathVariable Long id, Map<String, Object> map) {
		ScheduleDetail scheduleDetail = scheduleDetailService.get(id);
		map.put("scheduleDetail", scheduleDetail);
		return VIEW;
	}
}
