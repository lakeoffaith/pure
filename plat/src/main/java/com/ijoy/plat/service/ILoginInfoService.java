package com.ijoy.plat.service;

import java.util.List;

import com.ijoy.plat.domain.LoginInfo;

public interface ILoginInfoService {
	
	public Long insert(LoginInfo t);

	public void delete(Long id);
	public void update(LoginInfo t);

	public LoginInfo get(Long  id);

	public List<LoginInfo> getAll();
	public LoginInfo findByLogin(LoginInfo loginInfo);

	public Boolean checkExistLoginInfoByName(String name);
	public LoginInfo findExistLoginInfoByName(String name);

}
