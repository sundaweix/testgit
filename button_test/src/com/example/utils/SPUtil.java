// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SPUtil.java

package com.example.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil
{

	private static SharedPreferences sp;
	private static android.content.SharedPreferences.Editor editor;
	private static SPUtil instance = null;

	private SPUtil()
	{
	}

	public static SPUtil getInstance(Context context)
	{
		if (instance == null)
		{
			instance = new SPUtil();
			sp = context.getSharedPreferences("sputil", 0);
			editor = sp.edit();
		}
		return instance;
	}

	public String getPostJson()
	{
		return sp.getString("postJson", "");
	}

	public void setPostJson(String postJson)
	{
		editor.putString("postJson", postJson);
		editor.commit();
	}

	public int getRequestState()
	{
		return sp.getInt("request_state", 0);
	}

	public void setRequestState(int requestState)
	{
		editor.putInt("request_state", requestState);
		editor.commit();
	}

	public String getAllAppForUninstall()
	{
		return sp.getString("allAppForUninstall", "");
	}

	public void setAllAppForUninstall(String allAppForUninstall)
	{
		editor.putString("allAppForUninstall", allAppForUninstall);
		editor.commit();
	}

	public void setLastOpenPackgeName(String packageName)
	{
		editor.putString("lastPackageName", packageName);
		editor.commit();
	}

	public String getLastOpenPackgeName()
	{
		return sp.getString("lastPackageName", "");
	}

	public String getLastOpenTime()
	{
		return sp.getString("lastOpenTime", "");
	}

	public void setLastOpenTime(String lastOpenTime)
	{
		editor.putString("lastOpenTime", lastOpenTime);
		editor.commit();
	}

	public String getLastAppName()
	{
		return sp.getString("lastAppName", "");
	}

	public void setLastAppName(String lastAppName)
	{
		editor.putString("lastAppName", lastAppName);
		editor.commit();
	}

	public String getLastAppVerison()
	{
		return sp.getString("lastAppVersion", "");
	}

	public void setLastAppVerison(String lastAppVerison)
	{
		editor.putString("lastAppVersion", lastAppVerison);
		editor.commit();
	}

	public String getDiverInfoJson()
	{
		return sp.getString("divInfoJson", "");
	}

	public void setDiverInfoJson(String diverInfoJson)
	{
		editor.putString("divInfoJson", diverInfoJson);
		editor.commit();
	}

	public long getLongTime()
	{
		return sp.getLong("longTime", 0L);
	}

	public void setLongTime(long longTime)
	{
		editor.putLong("longTime", longTime);
		editor.commit();
	}

	public long getLastQuestTime()
	{
		return sp.getLong("lastQuestTime", 0L);
	}

	public void setLastQuestTime(long lastQuestTime)
	{
		editor.putLong("lastQuestTime", lastQuestTime);
		editor.commit();
	}

	public String getNetTypeChange()
	{
		return sp.getString("netType", "");
	}

	public void setNetTypeChange(String netTypeChange)
	{
		editor.putString("netType", netTypeChange);
		editor.commit();
	}

	public String getLocationChange()
	{
		return sp.getString("location", "");
	}

	public void setLocationChange(String locationChange)
	{
		editor.putString("location", locationChange);
		editor.commit();
	}

	public String getProcessLife()
	{
		return sp.getString("processLife", "");
	}

	public void setProcessLife(String processLife)
	{
		editor.putString("processLife", processLife);
		editor.commit();
	}

	public String getInstallAppJson()
	{
		return sp.getString("appJson", "");
	}

	public void setInstallAppJson(String installAppJson)
	{
		editor.putString("appJson", installAppJson);
		editor.commit();
	}

}
