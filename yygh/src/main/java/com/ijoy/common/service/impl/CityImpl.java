package com.ijoy.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.domain.City;
import com.ijoy.common.mapper.CityMapper;
import com.ijoy.common.query.CityQuery;
import com.ijoy.common.service.CityService;

@Service
public class CityImpl implements CityService {
    
	@Autowired
	CityMapper cityMapper;
	
	
	@Override
	public List<City> queryCityRows(CityQuery cityQuery) {
		return cityMapper.queryCityRows(cityQuery);
	}
	
	
	@Override
	public void save(City t) {
		cityMapper.insert(t);
	}

	@Override
	public void delete(Long id) {
		
		
	}

	@Override
	public void update(City t) {
		
		
	}

	@Override
	public City get(Long id) {
		
		return null;
	}



}
