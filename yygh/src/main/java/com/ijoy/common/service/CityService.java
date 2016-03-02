package com.ijoy.common.service;

import com.ijoy.common.domain.City;
import com.ijoy.common.query.CityQuery;
import com.ijoy.common.query.PageResult;

public interface CityService extends BaseCurdService<City> {

	PageResult<City> queryCityPage(CityQuery cityQuery);

}
