package com.ijoy.common.service;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.domain.Hospital;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.HospitalQuery;
import com.ijoy.common.query.PageResult;

public interface HospitalService extends BaseCurdService<Hospital> {

	/**
	 * 根据查询条件 如 省份,城市,区域,级别,类型  排序  eg:预约人数 ,eg:好评
	 */
	
	
	/**
	 * 用户查看自己收藏的医院,浏览过的医院,挂过号的医院
	 */
	
	public PageResult<Hospital> queryUserCollectHospital(Employee employee,Long type,BaseQuery baseQuery);

	public PageResult<Hospital> queryPage(HospitalQuery baseQuery);

	/**
	 * 用户与医院的关系进行保存
	 * @param hospital_id		医院id
	 * @param employee_id	用户id
	 * @param type					关系类型
	 * type=1为收藏
	 */
	public void insertHospitalJoinEmployee(Long hospital_id, Long employee_id, Long type);




}
