package com.xiaonian.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpsClient
{
	public static void main(String[] args)
	{
		try
		{
//			String name = URLEncoder.encode("萌", "UTF-8");
			
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
	        nvps.add(new BasicNameValuePair("name", "教室"));
			String str = EntityUtils.toString(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));  
			String requestUrl = "https://120.76:219.219:8443/xiaonian/api/dynamic/gethot";  
	        System.out.println(sendSSLRequest(requestUrl));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static String sendSSLRequest(String requestUrl){  
	    long responseLength = 0;       //响应长度  
	    String responseContent = null; //响应内容  
	    HttpClient httpClient = new DefaultHttpClient(); //创建默认的httpClient实例  
	    try {  
	        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());  
	        FileInputStream fis = new FileInputStream(new File("D:\\aaa.keystore"));  
	        try {  
	            trustStore.load(fis, "qingjiang1124".toCharArray()); //加载KeyStore  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                fis.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        SSLSocketFactory socketFactory = new SSLSocketFactory(trustStore);   //创建Socket工厂,将trustStore注入  
	        Scheme sch = new Scheme("https", 8443, socketFactory);               //创建Scheme  
	        httpClient.getConnectionManager().getSchemeRegistry().register(sch); //注册Scheme  
	        HttpGet httpGet = new HttpGet(requestUrl);           //创建HttpGet  
	        httpGet.setHeader("token", "24d14f36eedd9820aaa932e8bb286549");
//	        HttpPost httpPost = new HttpPost(requestUrl);
//	        httpPost.setHeader("token", "24d14f36eedd9820aaa932e8bb286549");
//	        
//	        List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
//	        nvps.add(new BasicNameValuePair("screenName", "你好"));  
//	        httpPost.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8)); 
	        
	        HttpResponse response = httpClient.execute(httpGet); //执行GET请求  
	        HttpEntity entity = response.getEntity();            //获取响应实体  
	        if (null != entity) {  
	            responseLength = entity.getContentLength();  
	            responseContent = EntityUtils.toString(entity, "UTF-8");  
	            EntityUtils.consume(entity); //Consume response content  
	        }  
	        System.out.println("请求地址: " + httpGet.getURI());  
	        System.out.println("响应状态: " + response.getStatusLine());  
	        System.out.println("响应长度: " + responseLength);  
	        System.out.println("响应内容: " + responseContent);  
	    } catch (Exception e) {  
	          e.printStackTrace();
	    } finally {  
	        httpClient.getConnectionManager().shutdown(); //关闭连接,释放资源  
	        return responseContent;  
	    }  
	}
}
  