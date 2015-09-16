// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ZLibUtils.java

package com.example.utils;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ZLibUtils
{

	public ZLibUtils()
	{
	}

	public static String compress(String str)
		throws IOException	
	{
		if (str==null||str.isEmpty()) {
		}
		if (str == null || str.length() == 0)
		{
			return str;
		} else
		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(out);
			gzip.write(str.getBytes());
			gzip.close();
			return out.toString("ISO-8859-1");
		}
	}

	public static String uncompress(String str)
		throws IOException
	{
		if (str == null || str.length() == 0)
			return str;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte buffer[] = new byte[256];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) 
			out.write(buffer, 0, n);
		return out.toString();
	}
}
