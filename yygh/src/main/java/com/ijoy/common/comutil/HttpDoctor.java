package com.ijoy.common.comutil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ijoy.common.domain.Department;
import com.ijoy.common.domain.Doctor;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;



public class HttpDoctor  {
	    
		public static JSONObject getJson() throws Exception{
		
			String urlString="http://localhost:8889/yygh/doctorData.json";
			
			String httpUtilResult = HttpUtil.httpGet(urlString);
			return JSONObject.fromObject(httpUtilResult);
		}
		
		/**
		 * 
		 *
		 * @return
		 * @throws Exception
		 */
		public static List<Doctor> getList(String cityLable) throws Exception{
			JSONObject jsonObject=getJson();
			List<Doctor> doctors=new ArrayList<>();
			JSONArray jsonArray=(JSONArray) jsonObject.get(cityLable);
			Iterator iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
					JSONObject next = (JSONObject) iterator.next();
					Doctor doctor = new Doctor();
					doctor.setName(next.getString("name"));
					doctor.setIntroduce(next.getString("introduce"));
					Department department = new Department();
					department.setId(next.getLong("department_id"));
					doctor.setDepartment(department);
					doctors.add(doctor);
			}
			
			
			return doctors;
		}
}
