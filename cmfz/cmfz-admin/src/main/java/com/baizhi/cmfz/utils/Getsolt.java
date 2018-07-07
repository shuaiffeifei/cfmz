package com.baizhi.cmfz.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

public class Getsolt {
	
	
	public static String encryption(String str) throws NoSuchAlgorithmException{
		MessageDigest md=MessageDigest.getInstance("MD5");
		byte[] code=md.digest(str.getBytes());
		StringBuilder builder=new StringBuilder();
		for(byte b:code){
			int c=b&0xFF;
			if(c<16){
				builder.append("0");
			}
			builder.append(Integer.toHexString(c));
		}
		return builder.toString();
	
	}
	
	public static String encryptionCodec(String str){		
		return DigestUtils.sha256Hex(str);
	}
	
	
	public static String getRandomSalt(int len){
		char[] chs="abcdefg1234567ABCDEFG".toCharArray();
		Random random=new Random();
		
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<len;i++){
			builder.append(chs[random.nextInt(chs.length)]);
		}
		return builder.toString();	
	}		
}
