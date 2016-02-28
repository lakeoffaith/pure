package com.ijoy.gh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.gh.query.DictionaryQuery;
import com.ijoy.gh.service.DictionaryService;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
	@Autowired
	DictionaryService dictionaryService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult search(@ModelAttribute  DictionaryQuery baseQuery){
		System.out.println(baseQuery);
		List dictionarys = dictionaryService.queryDictionary(baseQuery).getRows();
		return new Ajaxresult(true,dictionarys);
	}
}
