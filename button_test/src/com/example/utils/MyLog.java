// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MyLog.java

package com.example.utils;

import android.util.Log;


public class MyLog
{

	public MyLog()
	{
	}

	public static void e(String s, String s1)
	{
		Log.e(s, s1);
	}

	public static void e(String s, String s1, Throwable throwable)
	{
		Log.e(s, s1, throwable);
	}

	public static void d(String s, String s1)
	{
		Log.d(s, s1);
	}

	public static void d(String s, String s1, Throwable throwable)
	{
		Log.d(s , s1 , throwable);
	}

	public static void i(String s, String s1)
	{
		Log.i( s ,  s1);
	}

	public static void i(String s, String s1, Throwable throwable)
	{
		Log.i( s ,  s1 , throwable);
	}
}
