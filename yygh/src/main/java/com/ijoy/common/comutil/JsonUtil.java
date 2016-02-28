package com.ijoy.common.comutil;

import net.sf.json.JSONObject;

public class JsonUtil {

	 public static String getStringFromJson(JSONObject adata) {  
	        StringBuffer sb = new StringBuffer();  
	        sb.append("{");  
	        for(Object key:adata.keySet()){  
	            sb.append("\""+key+"\":\""+adata.get(key)+"\",");  
	        }  
	        String rtn = sb.toString().substring(0, sb.toString().length()-1)+"}";  
	        return rtn;  
	    } 
}
