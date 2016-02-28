package com.ijoy.common.comutil.dataCollection;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ijoy.common.domain.Hospital;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @author ijoy
 *调用接口加载成都的医院到数据库
 */
public class HospitalDataCollection {
	public static  List<Hospital> getHospitalRemoteList() {
		JSONObject json = getJson();
		List<Hospital> hospitals = jsonToDomain(json);
		  
		return hospitals;
	}
	
	
	/**
	 * get json
	 */
	public static  JSONObject getJson(){
		  OkHttpClient okHttpClient = new  OkHttpClient();
		  JSONObject jsonObject=null;
			 Request request= new Request.Builder().url("http://a.apix.cn/yi18/hospital/list?id=317")
					 .get()
					 .addHeader("accept", "application/json")
					 .addHeader("content-type", "application/json")
					 .addHeader("apix-key", "4ac282a47aa54cd24b9245aa9001af06")
					 .build();
			 try {
				Response response = okHttpClient.newCall(request).execute();
	      jsonObject = JSONObject.fromObject(response.body().string());
			} catch (IOException e) {
				e.printStackTrace();
			}
			 return jsonObject;
	}
	
	/**
	 * json 转换为相应domain的list
	 */
	public  static List jsonToDomain(JSONObject jsonObject){
		ArrayList<Hospital> arrayList = new ArrayList<>();
		JSONArray jsonArray=(JSONArray) jsonObject.get("yi18");
		Iterator iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
				JSONObject  obj = (JSONObject) iterator.next();
				Hospital  bean = (Hospital) JSONObject.toBean(obj, Hospital.class);
				arrayList.add(bean);
		}
		
		return arrayList;
	}
	
	
}
