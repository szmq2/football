/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.level.controller;

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
import com.ketayao.football.level.entity.Level;
import com.ketayao.football.level.service.LevelService;

@Controller
@RequestMapping("/management/level")
public class LevelController {

	@Autowired
	private LevelService levelService;
	
	private static final String CREATE = "management/level/create";
	private static final String UPDATE = "management/level/update";
	private static final String LIST = "management/level/list";
	private static final String VIEW = "management/level/view";
	
	@InitBinder
	public void dataBinder(WebDataBinder dataBinder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(df, true));
	}
	
	@RequiresPermissions("Level:save")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String preCreate(Map<String, Object> map) {
		return CREATE;
	}
	
	@Log(message="添加了id={0}队伍等级。")
	@RequiresPermissions("Level:save")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String create(@Valid Level level) {
		levelService.saveOrUpdate(level);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{level.getId()}));
		return AjaxObject.newOk("队伍等级添加成功！").toString();
	}
	
	@ModelAttribute("preloadLevel")
	public Level preload(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			Level level = levelService.get(id);
			return level;
		}
		return null;
	}
	
	@RequiresPermissions("Level:edit")
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		Level level = levelService.get(id);
		map.put("level", level);
		return UPDATE;
	}
	
	@Log(message="修改了id={0}队伍等级的信息。")
	@RequiresPermissions("Level:edit")
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String update(@Valid @ModelAttribute("preloadLevel")Level level) {
		levelService.saveOrUpdate(level);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{level.getId()}));
		return AjaxObject.newOk("队伍等级修改成功！").toString();
	}

	@Log(message="删除了id={0}队伍等级。")
	@RequiresPermissions("Level:delete")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable Long id) {
		levelService.delete(id);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{id}));
		return AjaxObject.newOk("队伍等级删除成功！").setCallbackType("").toString();
	}
	
	@Log(message="批量删除了id={0}队伍等级。")
	@RequiresPermissions("Level:delete")
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody String deleteMany(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Level level = levelService.get(ids[i]);
			levelService.delete(level.getId());
		}
		
		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{Arrays.toString(ids)}));
		return AjaxObject.newOk("队伍等级删除成功！").setCallbackType("").toString();
	}

	@RequiresPermissions("Level:view")
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(ServletRequest request, Page page, Map<String, Object> map) {
		Specification<Level> specification = DynamicSpecifications.bySearchFilter(request, Level.class);
		List<Level> levels = levelService.findByExample(specification, page);
		
		map.put("page", page);
		map.put("levels", levels);

		return LIST;
	}
	
	@RequiresPermissions("Level:view")
	@RequestMapping(value="/view/{id}", method={RequestMethod.GET})
	public String view(@PathVariable Long id, Map<String, Object> map) {
		Level level = levelService.get(id);
		map.put("level", level);
		return VIEW;
	}
}
