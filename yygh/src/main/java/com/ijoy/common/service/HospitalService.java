package com.ijoy.common.service;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.domain.Hospital;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;

public interface HospitalService extends BaseCurdService<Hospital> {

	/**
	 * 根据查询条件 如 省份,城市,区域,级别,类型  排序  eg:预约人数 ,eg:好评
	 */
	
	public PageResult<Hospital> queryHospital(BaseQuery basequery);
	
	/**
	 * 用户查看自己收藏的医院,浏览过的医院,挂过号的医院
	 */
	
	public PageResult<Hospital> queryUserCollectHospital(Employee employee,Long type,BaseQuery baseQuery);




}
