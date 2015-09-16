// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TimeUtils.java

package com.example.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils
{

	public TimeUtils()
	{
	}

	public static String longToTime(long currrentMillons)
	{
		Date date = new Date(currrentMillons);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return (new StringBuilder(String.valueOf(format.format(date)))).append(":").toString();
	}

	public static boolean IsNetWork(Context ctx)
	{
		boolean flag = false;
		ConnectivityManager manager = (ConnectivityManager)ctx.getSystemService("connectivity");
		android.net.NetworkInfo.State mobile = manager.getNetworkInfo(0).getState();
		android.net.NetworkInfo.State wifi = manager.getNetworkInfo(1).getState();
		if (wifi == android.net.NetworkInfo.State.CONNECTED || wifi == android.net.NetworkInfo.State.CONNECTING)
			flag = true;
		if (mobile == android.net.NetworkInfo.State.CONNECTED || mobile == android.net.NetworkInfo.State.CONNECTING)
			flag = true;
		return flag;
	}
}
