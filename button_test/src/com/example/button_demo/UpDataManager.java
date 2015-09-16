package com.example.button_demo;


import org.json.JSONException;
import org.json.JSONObject;

import com.example.utils.Constants;
import com.example.utils.MyLog;
import com.example.utils.SPUtil;
import com.example.utils.TimeUtils;
import com.example.utils.ZLibUtils;

import android.content.Context;


public class UpDataManager {
	private Context context;
	private static UpDataManager instance;

	public static synchronized UpDataManager getInstance(Context context)
	{
		if (instance == null)
			instance = new UpDataManager(context);
		return instance;
	}

	private UpDataManager(Context context)
	{
		this.context = context;
	}
	
	public void StartpostData(Context context, String data)
	{
		SPUtil spUtil = SPUtil.getInstance(context);
		//MyLog.e("qqqqqqqqqqqqqqqqqqqq", "" + (System.currentTimeMillis()) + " " + spUtil.getLastQuestTime());
		//24小时上报 System.currentTimeMillis()- spUtil.getLastQuestTime() > 0x5265c00L
		if (spUtil.getRequestState() == 0)
		{
			MyLog.e("SDKTAG", "开启上传流程了...");
			if (!TimeUtils.IsNetWork(context))
				return;
			spUtil.setRequestState(1);
			Upload(data);			
		}
	}
	
	private void Upload(String data) {
		// TODO Auto-generated method stub
		MyLog.e("SDKTAG", "task开始进行...");
		String key = "5326727986390677a";
		MyLog.e("SDKTAG", (new StringBuilder("看看读取的数据：")).append(key).toString());
		String getResult = ConnectionClient.sendGet(Constants.UPDATE_URL, key);
		MyLog.e("SDKTAG", (new StringBuilder("get请求返回值：")).append(getResult).toString());
		MyLog.e("SDKTAG", (new StringBuilder("要上传的数据信息JSONdata：")).append(data).toString());
		String postRsult = "";
		try
		{
			MyLog.e("SDKTAG", "开始压缩");
			postRsult = ConnectionClient.sendPost(Constants.UPLOAD_URL, "facility", ZLibUtils.compress(data));			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		handlerAfterPost(postRsult);
		MyLog.e("SDKTAG", "task进行完毕....");
		return;
	}

	public void handlerAfterPost(String response)
	{
		MyLog.e("SDKTAG", (new StringBuilder("post请求返回值：")).append(response).toString());
		SPUtil spUtil = SPUtil.getInstance(context);
		try
		{   
			MyLog.e("SDKTAG", "数据准备上传.....");
			JSONObject jsonObject = new JSONObject(response);
			if (jsonObject.getString("code").equals("100") || jsonObject.getString("code").equals("200") || jsonObject.getString("code").equals("400"))
			{
				spUtil.setLastQuestTime(System.currentTimeMillis());
				MyLog.e("SDKTAG", "数据上传成功了！");
				spUtil.setPostJson("");
			}
		}
		catch (JSONException e)
		{
			MyLog.e("SDKTAG", "数据上传失败了！");
			e.printStackTrace();
		}
		spUtil.setRequestState(0);
	}
	
}
