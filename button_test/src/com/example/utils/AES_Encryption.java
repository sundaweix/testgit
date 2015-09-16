// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AES_Encryption.java

package com.example.utils;

import java.io.UnsupportedEncodingException;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES_Encryption
{

	private static final String HEX = "0123456789ABCDEF";

	public AES_Encryption()
	{
	}

	public static String encrypt(String key, String data)
		throws Exception
	{
		byte rawKey[] = key.getBytes();
		byte result[] = encrypt(rawKey, data.getBytes());
		return toHex(result);
	}

	private static byte[] encrypt(byte raw[], byte clear[])
		throws Exception
	{
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(1, skeySpec);
		byte encrypted[] = cipher.doFinal(clear);
		return encrypted;
	}

	private static String toHex(byte buf[])
	{
		if (buf == null)
			return "";
		StringBuffer result = new StringBuffer(2 * buf.length);
		for (int i = 0; i < buf.length; i++)
			appendHex(result, buf[i]);

		return result.toString();
	}

	private static void appendHex(StringBuffer sb, byte b)
	{
		sb.append("0123456789ABCDEF".charAt(b >> 4 & 0xf)).append("0123456789ABCDEF".charAt(b & 0xf));
	}

	public static String decrypt(String key, String data)
	{
		byte result[] = null;
		if (data != null)
			try
			{
				byte rawKey[] = key.getBytes();
				byte enc[] = toByte(data);
				result = decrypt(rawKey, enc);
			}
			catch (Exception exception) { }
		return new String(result);
	}

	private static byte[] decrypt(byte raw[], byte encrypted[])
		throws Exception
	{
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(2, skeySpec);
		byte decrypted[] = cipher.doFinal(encrypted);
		return decrypted;
	}

	private static byte[] toByte(String hexString)
	{
		int len = hexString.length() / 2;
		byte result[] = new byte[len];
		for (int i = 0; i < len; i++)
			result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();

		return result;
	}

	public static String encryptBASE64(String str)
	{
		if (str == null || str.length() == 0)
			return null;
		byte encode[];
		try {
			encode = str.getBytes("UTF-8");
			return new String(Base64.encode(encode, 0, encode.length, 0), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

	public static String decryptBASE64(String str)
	{
		if (str == null || str.length() == 0)
			return null;
		byte encode[];
		try {
			encode = str.getBytes("UTF-8");
			return new String(Base64.decode(encode, 0, encode.length, 0), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
