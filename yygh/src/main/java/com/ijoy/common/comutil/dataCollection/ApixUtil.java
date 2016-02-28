package com.ijoy.common.comutil.dataCollection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class ApixUtil {
	/**
	 *changeFileMap     key   is   oldFile   ;value  is newFile;          
	 */
		public static final String CHANGEFILEMAP = "changeFileMap";
		public static final String FILTERFILELIST = "FilterFileList";



		public static List getLIst(String url,Class className,Map jsonDealMap){
			return jsonToDomain(getJson(url), className,jsonDealMap);
		}
		
		
		
		/**
		 * get jsonObject
		 */
		public static  JSONObject getJson(String url){
			  OkHttpClient okHttpClient = new  OkHttpClient();
			  JSONObject jsonObject=null;
				 Request request= new Request.Builder().url(url)
						 .get()
						 .addHeader("accept", "application/json")
						 .addHeader("content-type", "application/json")
						 .addHeader("apix-key", "4ac282a47aa54cd24b9245aa9001af06")
						 .build();
				 try {
					Response response = okHttpClient.newCall(request).execute();
		      jsonObject = JSONObject.fromObject(response.body().string());
		      System.out.println(jsonObject);
				} catch (IOException e) {
					e.printStackTrace();
					return jsonObject;
				}
				 return jsonObject;
		}
		
		/**
		 * json 转换为相应domain的list
		 */
		public  static List jsonToDomain(JSONObject jsonObject,Class className,Map dealJsonMap){
			
			List  arrayList = new ArrayList<>();
			JSONArray jsonArray=(JSONArray) jsonObject.get("yi18");
			Iterator iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				
				JSONObject  obj =JSONObject.fromObject(iterator.next());
				//处理json和bean的差异
				obj=ApixConfigDeal(obj,dealJsonMap);
					Object  bean = JSONObject.toBean(obj, className);
					arrayList.add(bean);
			}
			
			return arrayList;
		}



		private static JSONObject ApixConfigDeal(JSONObject obj,Map<String,Object> map) {
			try {
				if(map.containsKey(ApixUtil.CHANGEFILEMAP) ){
					//跟改属性名changeFileMap
					Map<String ,Object> changeFileMap=(Map<String, Object>) map.get(ApixUtil.CHANGEFILEMAP);
					Set entrySet = changeFileMap.entrySet();
					Iterator iterator = entrySet.iterator();
					while(iterator.hasNext()){
						Map.Entry<String ,Object>  next = (Entry<String, Object>) iterator.next();
						String  old = next.getKey();
						
						if(obj.containsKey(old)){
							Object oldval=obj.get(old);
							obj.remove(old);
							obj.put(next.getValue().toString(), oldval);
						}
					}
				}
				if(map.containsKey(ApixUtil.FILTERFILELIST) ){
					//过滤属性
					String[] filterFileArray =  (String[]) map.get(ApixUtil.FILTERFILELIST);
					JsonConfig jsonConfig=new JsonConfig();
					jsonConfig.setExcludes(filterFileArray);
					obj = JSONObject.fromObject(obj, jsonConfig);
					
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
			
			
			return obj;
		}
		
}
