package com.ijoy.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.plat.mapper.IncomeMapper;
import com.ijoy.plat.query.IncomeQuery;
import com.ijoy.plat.service.IncomeService;

@Service
public class IncomeServiceImpl  implements IncomeService{
	@Autowired
	private IncomeMapper mapper;
	@Override
	public List queryIncome(IncomeQuery incomeQuery) {
		return mapper.queryIncome( incomeQuery);
	}

}
