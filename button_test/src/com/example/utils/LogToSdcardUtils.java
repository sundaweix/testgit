// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LogToSdcardUtils.java

package com.example.utils;

import android.os.Environment;
import java.io.*;

// Referenced classes of package com.eguan.drivermonitor.utils:
//			MyLog

public class LogToSdcardUtils
{

	public LogToSdcardUtils()
	{
	}

	public static void writeToSdcard(String content)
		throws Exception
	{
		String st = new String(content.getBytes(), "utf-8");
		File file = new File(Environment.getExternalStorageDirectory(), "analysys1.txt");
		OutputStream out = new FileOutputStream(file, true);
		out.write(st.getBytes());
		out.close();
	}

	public static void saveToSDcard(String content)
	{
		String en = Environment.getExternalStorageState();
		if (en.equals("mounted"))
			try
			{
				writeToSdcard((new StringBuilder("\r\n")).append(content).toString());
			}
			catch (Exception e)
			{
				MyLog.e("SDKTAG", "�Ҳ���SD��");
			}
	}
}
