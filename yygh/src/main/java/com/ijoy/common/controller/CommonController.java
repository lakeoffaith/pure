package com.ijoy.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.domain.City;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.CityQuery;
import com.ijoy.common.service.CityService;

@Controller
@RequestMapping("/common/")
public class CommonController {
	@Autowired
	CityService cityService;
	
	
	@RequestMapping(value="citypop",params="do=search")
	@ResponseBody
	public Map searchcity() throws Exception{
		System.out.println("enter searchCity");
		
		CityQuery cityQuery=new CityQuery();
		cityQuery.setPageSize(BaseQuery.MAXPAGESIZE_1000);
		cityQuery.setLevel(City.HOT_LEVEL_ONE);
		List<City>   hotCities=cityService.queryCityPage(cityQuery).getRows();
		CityQuery chineseCitiesQuery=new CityQuery();
		//条件为拼音不能为空就行
		  chineseCitiesQuery.setPageSize(BaseQuery.MAXPAGESIZE_1000);
		  chineseCitiesQuery.setConditionStr("pinyin_not_null");
		List<City> chineseCities=cityService.queryCityPage(chineseCitiesQuery).getRows();
		Map<String,Object> map = new HashMap<>();
		map.put("hotCities", hotCities);
		map.put("chineseCities", chineseCities);
		return map;
	}

}
