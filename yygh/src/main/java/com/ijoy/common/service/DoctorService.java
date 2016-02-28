package com.ijoy.common.service;

import com.ijoy.common.domain.Doctor;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;

public interface DoctorService extends BaseCurdService<Doctor> {

	/**
	 * 根据查询条件 如医院(list),科室,科室分类 内科   排序  eg:预约人数 ,eg:好评
	 */
	
	public PageResult<Doctor> queryDoctor(BaseQuery basequery);
	
	/**
	 * 用户查看自己收藏的医生,浏览过的医生,挂过号的医生
	 */
	
	public PageResult<Doctor> queryUserCollectDoctor(Employee employee,Long type,BaseQuery baseQuery);

	


}
