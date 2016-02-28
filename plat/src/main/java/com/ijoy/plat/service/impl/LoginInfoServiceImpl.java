package com.ijoy.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.plat.domain.Employee;
import com.ijoy.plat.domain.LoginInfo;
import com.ijoy.plat.domain.Role;
import com.ijoy.plat.domain.Sysloginfo;
import com.ijoy.plat.mapper.EmployeeMapper;
import com.ijoy.plat.mapper.LoginInfoMapper;
import com.ijoy.plat.mapper.RoleMapper;
import com.ijoy.plat.mapper.SysloginfoMapper;
import com.ijoy.plat.service.ILoginInfoService;

@Service
public class LoginInfoServiceImpl  implements ILoginInfoService {
	@Autowired
    private LoginInfoMapper mapper;
	@Autowired
    private EmployeeMapper employeeMapper;
	@Autowired
    private RoleMapper roleMapper;
	@Autowired
    private SysloginfoMapper sysloginfoMapper;
	@Override
	public LoginInfo findByLogin(LoginInfo loginInfo) {
		return mapper.findByLogin(loginInfo);
	}
	
	@Override
	public LoginInfo findExistLoginInfoByName(String name) {
		return mapper.checkExistLoginInfoByName(name);
	}

	@Override
	public Boolean checkExistLoginInfoByName(String name) {
		return mapper.checkExistLoginInfoByName(name)!=null;
	}
	@Override
	public Long insert(LoginInfo loginInfo){
		//为了让事物起作用,必须放在service中
		Long loginInfoID = mapper.insert(loginInfo);
		 //* 2：保存用户
		 
		Employee employee = new Employee();
		//
		employee.setId(loginInfoID);
		employee.setName(loginInfo.getName());
		//用户的默认角色设置  11L为普通用户角色
		Role role=roleMapper.getRoleByName("普通用户");
		employee.setRole(role);
		employeeMapper.insert(employee);
		
		 //* 3:保存Sysloginfo
		 
		Sysloginfo sysloginfo = new Sysloginfo();
		sysloginfo.setId(loginInfoID);
		sysloginfoMapper.insert(sysloginfo);
		return loginInfoID;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LoginInfo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LoginInfo get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoginInfo> getAll() {
		return mapper.getAll();
	}


	

	
	
}
