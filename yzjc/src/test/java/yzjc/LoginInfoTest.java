package yzjc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.comutil.MD5Util;
import com.ijoy.common.domain.LoginInfo;
import com.ijoy.common.service.ILoginInfoService;

public class LoginInfoTest  extends BaseTest{
	@Autowired
	private ILoginInfoService loginInfoService;
	
	@Test
	public void UpdateMd5Password(){
		Long id=1L;
		LoginInfo loginInfo = loginInfoService.get(id);
		String password = loginInfo.getPassword();
		if(password.length()<10){
			loginInfo.setPassword(MD5Util.JM(MD5Util.MD5(password)));
			loginInfoService.update(loginInfo);
		}
	}
		
}
