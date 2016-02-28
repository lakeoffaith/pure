package com.ijoy.common.service;

import java.util.List;

import com.ijoy.common.domain.City;
import com.ijoy.common.query.CityQuery;

public interface CityService extends BaseCurdService<City> {

	List<City> queryCityRows(CityQuery cityQuery);

}
