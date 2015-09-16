// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ConnectionClient.java

package com.example.button_demo;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

import android.util.Log;


public class ConnectionClient
{

	public ConnectionClient()
	{
	}

	public static String sendPost(String url, String name, String value)
	{
		String response;
		HttpClient httpClient;
		response = "";
		httpClient = null;
		try
		{
			httpClient = new DefaultHttpClient();
			HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), 5000);
			HttpConnectionParams.setSoTimeout(httpClient.getParams(), 5000);
			HttpPost httpPost = new HttpPost(url);
			List list = new ArrayList();
			list.add(new BasicNameValuePair(name, value));
			HttpEntity httpEntity = new UrlEncodedFormEntity(list, "utf-8");
			httpPost.setEntity(httpEntity);
			//Log.e("url", "url:"+url);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			if (httpResponse.getStatusLine().getStatusCode() == 200)
			{
				HttpEntity he = httpResponse.getEntity();
				response = EntityUtils.toString(he);
			} else
			{
				response = "";
			}
		}catch(Exception e){
			httpClient.getConnectionManager().shutdown();
			e.printStackTrace();
		}
//		catch (ClientProtocolException clientprotocolexception)
//		{
//			httpClient.getConnectionManager().shutdown();
//			break MISSING_BLOCK_LABEL_230;
//		}
//		catch (NoHttpResponseException nohttpresponseexception)
//		{
//			httpClient.getConnectionManager().shutdown();
//			break MISSING_BLOCK_LABEL_230;
//		}
//		catch (IOException ioexception)
//		{
//			httpClient.getConnectionManager().shutdown();
//			break MISSING_BLOCK_LABEL_230;
//		}
//		break MISSING_BLOCK_LABEL_218;
//		Exception exception;
//		exception;
//		httpClient.getConnectionManager().shutdown();
//		throw exception;
//		httpClient.getConnectionManager().shutdown();
		return response;
	}

	public static String sendPost3(String url, String params)
		throws IOException
	{
		URL realurl = null;
		InputStream in = null;
		HttpURLConnection conn = null;
		StringBuilder sb = null;
		try
		{
			realurl = new URL(url);
			conn = (HttpURLConnection)realurl.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			PrintWriter pw = new PrintWriter(conn.getOutputStream());
			pw.print(params);
			pw.flush();
			pw.close();
			in = conn.getInputStream();
			InputStreamReader streamRead = new InputStreamReader(in);
			BufferedReader bufferReader = new BufferedReader(streamRead);
			sb = new StringBuilder();
			for (String line = null; (line = bufferReader.readLine()) != null;)
				sb.append((new StringBuilder(String.valueOf(line))).append("/n").toString());

		}
		catch (MalformedURLException malformedurlexception) { }
		return sb.toString();
	}

	public static String sendGet(String url, String params)
	{
		String result = "";
		String URL = (new StringBuilder(String.valueOf(url))).append("?params=").append(params).toString();
		try
		{
			URL getUrl = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection)getUrl.openConnection();
			connection.setConnectTimeout(5000);
			Log.e("url", "url:"+getUrl);
			connection.connect();
			BufferedReader reader = null;
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			for (String lines = null; (lines = reader.readLine()) != null;)
				result = (new StringBuilder(String.valueOf(result))).append(lines).toString();

			reader.close();
			connection.disconnect();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
