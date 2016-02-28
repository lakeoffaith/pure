package com.ijoy.common.service;

import java.util.List;

import com.ijoy.common.domain.Department;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;
/**
 * 科室的service层
 * @author zhengang
 *
 */
public interface DepartmentService extends BaseCurdService<Department> {

	/**
	 * 根据查询条件 如 医院(list),科室,科室分类 内科,国家级别  eg:国家重点   排序  eg:预约人数 ,eg:好评
	 */
	
	public PageResult<Department> queryDepartment(BaseQuery basequery);
	
	/**
	 * 用户查看自己收藏的科室,浏览过的科室,挂过号的科室
	 */
	
	public PageResult<Department> queryUserCollectDepartment(Employee employee,Long type,BaseQuery baseQuery);
	
	/**
	 * 当用户点击医院的时候，得到科室有多少个分类，再调用queryDepartment 得知每个分类下面有多少科室
	 */
	
	public List<String> findDepartmentTypeListByHospitalId(Long hospitalId);


}
