// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Rijndael.java

package com.example.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Rijndael
{

	public Rijndael()
	{
	}

	public static byte[] parseHexStr2Byte(String hexStr)
	{
		if (hexStr.length() < 1)
			return null;
		byte result[] = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++)
		{
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte)(high * 16 + low);
		}

		return result;
	}

	public static byte[] decrypt(byte content[], String password)
	{
		byte result[];
		try{
			SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(2, key);
			result = cipher.doFinal(content);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
