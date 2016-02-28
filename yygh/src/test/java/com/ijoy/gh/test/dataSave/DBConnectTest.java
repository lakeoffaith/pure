package com.ijoy.gh.test.dataSave;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.gh.test.BaseTest;

public class DBConnectTest extends BaseTest {
	 @Autowired
	 SqlSessionFactory sqlSessionFactory;
	 
	 @Test
	 public void DBTest(){
		 SqlSession session = sqlSessionFactory.openSession();
		
		 String sql="insert into orderItem(score) value (13)";
		int insert = session.insert(sql);
		session.commit();
		 System.out.println(insert);
	 }
}
