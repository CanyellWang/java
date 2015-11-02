package com.zhao.esayui.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Encoder;

public class MessageUtil {
	/**
	 * ����UUID�㷨����һ���ַ���
	 * @return
	 */
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		String uid =  uuid.toString();
		return uid.replace("-", "");
	}
	
	/**
	 * ���������Ϣ����md5����
	 * ������
	 * ���ⳤ�ȱ�ȳ�
	 * @param message
	 * @return
	 */
	public static String md5(String message){
		try {
			MessageDigest md = 
				MessageDigest.getInstance("MD5");
			byte[] input = message.getBytes();
			byte[] output = md.digest(input);//���ֽ���Ϣ����
			//����base64�����ܺ���ֽ���Ϣת���ַ���
			String str = base64Encode(output);
			return str;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
	/**
	 * ����Base64�㷨���ֽ���Ϣת���ַ���
	 * @param input
	 * @return
	 * jdk6.0�Դ���API
	 */
	public static String base64Encode1(byte[] input){
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(input);
	}
	//����commons-codec-1.9.jar
	public static String base64Encode(byte[] input){
		 return Base64.encodeBase64String(input);
	}
	
	public static String base64Decode(String msg){
		try{
			byte[] output = Base64.decodeBase64(msg);
			return new String(output,"UTF-8");
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args){
		System.out.println(md5("123456"));
//		System.out.println(md5("ddddddddddddddd"));
//		System.out.println(md5("a"));
//		System.out.println(getUUID());
//		System.out.println(getUUID());
	}
	
	
	
}
