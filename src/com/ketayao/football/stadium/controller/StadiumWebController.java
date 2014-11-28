/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.stadium.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ketayao.football.stadium.entity.Stadium;
import com.ketayao.football.stadium.service.StadiumService;
import com.ketayao.ketacustom.util.dwz.Page;
import com.ketayao.ketacustom.util.persistence.DynamicSpecifications;

@Controller
@RequestMapping("/web/stadium")
public class StadiumWebController {

	@Autowired
	private StadiumService stadiumService;
	
	private static final String LIST = "web/stadium/list";

	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(ServletRequest request, Page page, Map<String, Object> map) {
		Specification<Stadium> specification = DynamicSpecifications.bySearchFilter(request, Stadium.class);
		List<Stadium> stadiums = stadiumService.findByExample(specification, page);
		
		map.put("page", page);
		map.put("stadiums", stadiums);

		return LIST;
	}
	
}
