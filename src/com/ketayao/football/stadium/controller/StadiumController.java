/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.stadium.controller;

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
import com.ketayao.football.stadium.entity.Stadium;
import com.ketayao.football.stadium.service.StadiumService;

@Controller
@RequestMapping("/management/stadium")
public class StadiumController {

	@Autowired
	private StadiumService stadiumService;
	
	private static final String CREATE = "management/stadium/create";
	private static final String UPDATE = "management/stadium/update";
	private static final String LIST = "management/stadium/list";
	private static final String VIEW = "management/stadium/view";
	
	@InitBinder
	public void dataBinder(WebDataBinder dataBinder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(df, true));
	}
	
	@RequiresPermissions("Stadium:save")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String preCreate(Map<String, Object> map) {
		return CREATE;
	}
	
	@Log(message="添加了id={0}体育场。")
	@RequiresPermissions("Stadium:save")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String create(@Valid Stadium stadium) {
		stadiumService.saveOrUpdate(stadium);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{stadium.getId()}));
		return AjaxObject.newOk("体育场添加成功！").toString();
	}
	
	@ModelAttribute("preloadStadium")
	public Stadium preload(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			Stadium stadium = stadiumService.get(id);
			return stadium;
		}
		return null;
	}
	
	@RequiresPermissions("Stadium:edit")
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		Stadium stadium = stadiumService.get(id);
		map.put("stadium", stadium);
		return UPDATE;
	}
	
	@Log(message="修改了id={0}体育场的信息。")
	@RequiresPermissions("Stadium:edit")
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String update(@Valid @ModelAttribute("preloadStadium")Stadium stadium) {
		stadiumService.saveOrUpdate(stadium);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{stadium.getId()}));
		return AjaxObject.newOk("体育场修改成功！").toString();
	}

	@Log(message="删除了id={0}体育场。")
	@RequiresPermissions("Stadium:delete")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable Long id) {
		stadiumService.delete(id);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{id}));
		return AjaxObject.newOk("体育场删除成功！").setCallbackType("").toString();
	}
	
	@Log(message="批量删除了id={0}体育场。")
	@RequiresPermissions("Stadium:delete")
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody String deleteMany(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Stadium stadium = stadiumService.get(ids[i]);
			stadiumService.delete(stadium.getId());
		}
		
		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{Arrays.toString(ids)}));
		return AjaxObject.newOk("体育场删除成功！").setCallbackType("").toString();
	}

	@RequiresPermissions("Stadium:view")
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(ServletRequest request, Page page, Map<String, Object> map) {
		Specification<Stadium> specification = DynamicSpecifications.bySearchFilter(request, Stadium.class);
		List<Stadium> stadiums = stadiumService.findByExample(specification, page);
		
		map.put("page", page);
		map.put("stadiums", stadiums);

		return LIST;
	}
	
	@RequiresPermissions("Stadium:view")
	@RequestMapping(value="/view/{id}", method={RequestMethod.GET})
	public String view(@PathVariable Long id, Map<String, Object> map) {
		Stadium stadium = stadiumService.get(id);
		map.put("stadium", stadium);
		return VIEW;
	}
}
