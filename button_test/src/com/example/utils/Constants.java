// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Constants.java

package com.example.utils;


// Referenced classes of package com.eguan.drivermonitor.utils:
//			Rijndael

public class Constants
{

	public static final String SDK_VERSION = "2.0.1|150827";
	public static boolean GL = true;
	public static final boolean IS_DEBUG = false;
	public static final String TAG = "SDKTAG";
	public static final String UPLOAD_KEY = "facility";
	public static final String URL_KEY = "key of DataTesla";
	//http://api2.analysys.cn:8089
	public static final String UPLOAD_DATA_URL = "4A670AC691570CB693F6505850471BA2726D3C8CD403DA689CCAC20CC90809C7";
	//http://api0.analysys.com.cn/ark-acquisition-api/third/query.shtml
	public static final String CONFIGURATION_URL = "788EF2688C1D36406A2919CC3FF6E99A0E14D34A790D5DF597EA7B42979FD5459CAC674B001A9CC0577B2E77F0DF80132E3826B722878A28A5914CB3B6CA7400764EDDE95AF9909BC34FAFBD572ADF5D";
	
	
	//http://api2.analysys.cn:8089
	public static final String UPLOAD_URL = new String(Rijndael.decrypt(Rijndael.parseHexStr2Byte("4A670AC691570CB693F6505850471BA2726D3C8CD403DA689CCAC20CC90809C7"), "key of DataTesla"));
	//http://api0.analysys.com.cn/ark-acquisition-api/third/query.shtml
	public static final String UPDATE_URL = new String(Rijndael.decrypt(Rijndael.parseHexStr2Byte("788EF2688C1D36406A2919CC3FF6E99A0E14D34A790D5DF597EA7B42979FD5459CAC674B001A9CC0577B2E77F0DF80132E3826B722878A28A5914CB3B6CA7400764EDDE95AF9909BC34FAFBD572ADF5D"), "key of DataTesla"));
	public static final String ACTION_ALARM_TIMER = "com.android.eguan.drivermonitor";
	public static final String REQUEST_STATE = "request_state";
	public static final String POSTJSON = "postJson";
	public static final String SPUTIL = "sputil";
	public static final String APP_KEY = "monitor_app_key";
	public static final String APP_CHANNEL = "monitor_app_channel";
	public static final String LASTOPENTIME = "lastOpenTime";
	public static final String LASTAPPNAME = "lastAppName";
	public static final String LASTAPPVERSION = "lastAppVersion";
	public static final String APPJSON = "appJson";
	public static final String LASTPACKAGENAME = "lastPackageName";
	public static final String NETTYPE = "netType";
	public static final String LOCATION = "location";
	public static final String PROCESSLIFE = "processLife";
	public static final String LASTQUESTTIME = "lastQuestTime";
	public static final String LONGTIME = "longTime";
	public static final String DIVINFOJSON = "divInfoJson";
	public static final String ALLAPPFORUNINSTALL = "allAppForUninstall";
	public static final String ENCODE = "utf-8";
	public static final String NETTYPECHANGE_ACTION = "com.eguan.drivermonitor.netTypeChange";
	public static final String MONITORSERVICE = "com.eguan.drivermonitor.service.MonitorService";
	public static final int TIME_INVALID = 5000;
	public static final int TIME_REQUEST_INVALIED = 0x5265c00;

	public Constants()
	{
	}
	
	public static void main(String[] args) {
		System.out.println(new String(Rijndael.decrypt(Rijndael.parseHexStr2Byte("4A670AC691570CB693F6505850471BA2726D3C8CD403DA689CCAC20CC90809C7"), "key of DataTesla")));
	}

}
