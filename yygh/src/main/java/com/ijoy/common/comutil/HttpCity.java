package com.ijoy.common.comutil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ijoy.common.domain.City;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;



public class HttpCity  {
	    
		public static JSONObject getJson() throws Exception{
		
			String urlString="http://localhost:8889/yygh/citypy.json";
			
			String httpUtilResult = HttpUtil.httpGet(urlString);
			return JSONObject.fromObject(httpUtilResult);
		}
		
		/**
		 * 
		 * @param cityLable  chineseCities  hotCities
		 * @return
		 * @throws Exception
		 */
		public static List<City> getList(String cityLable) throws Exception{
			JSONObject jsonObject=getJson();
			List<City> cities=new ArrayList<>();
			String[] excluedsArrays=new String[]{"label"};
			JSONArray jsonArray=(JSONArray) jsonObject.get(cityLable);
			
			Iterator iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
					JSONObject next = (JSONObject) iterator.next();
					JsonConfig jsonConfig=new JsonConfig();
					jsonConfig.setExcludes(excluedsArrays);
					next=JSONObject.fromObject(next, jsonConfig);
					City bean = (City) JSONObject.toBean(next, City.class);
					cities.add(bean);
			}
			
			
			return cities;
		}
}
