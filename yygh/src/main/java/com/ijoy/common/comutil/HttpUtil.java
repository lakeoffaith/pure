package com.ijoy.common.comutil;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public  class HttpUtil {
	
	public static String httpGet(String url) throws Exception{
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpEntity entity;

		String result=null;
		try {
			HttpGet httpGet=new HttpGet(url);
			
			CloseableHttpResponse response = httpClient.execute(httpGet);
			
			try {
				if(response.getStatusLine().getStatusCode()==200){
					entity = response.getEntity();
					result= EntityUtils.toString(entity,"utf-8");
					EntityUtils.consume(entity);	
				}
			}finally{
				response.close();
			}
		}finally{
		   httpClient.close();
		}
		return result;
	}
	
	
	
	public static String  httpPost(String url,List<BasicNameValuePair> parmaslist) throws Exception{
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpEntity entity;
		String result=null;
		try {
			HttpPost httpPost=new HttpPost(url);
			if (parmaslist.size()>0) {
			 UrlEncodedFormEntity urlEncodedFormEntity=	new UrlEncodedFormEntity(parmaslist, "utf-8");
				httpPost.setEntity(urlEncodedFormEntity);
				
			}
			
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				
				if(response.getStatusLine().getStatusCode()==200){
					entity = response.getEntity();
					result= EntityUtils.toString(entity,"utf-8");
					EntityUtils.consume(entity);	
				}
				
			}finally{
				response.close();
			}
		}finally{
			httpClient.close();
		}
		return result;
	}
	
	 
}
