package com.pctc.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5�����㷨
 * pkd
 */
public class MD5Util {

	/**
	 * MD5ֵ
	 * �����Ҫ��ת��������뱣�浽���ݿ��У���Ҫʹ�õ�����Ϊ��char(32)
	 */
	public static String encryptMD5(String inStr) {

		MessageDigest md5 = null;
		try {
			// ��ȡMessageDigest���󣬸ö�����ɼ���
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return null;
		}
		// ��Ҫ���ܵ���Ϣת�����ֽ����飬��ʹ��ת������ֽ������ʼ��MessgeDigest����
		md5.update(inStr.getBytes());
		// ����digest�������м��ܣ�����byte����
		byte[] hash = md5.digest();
		StringBuffer hexValue = new StringBuffer();
		int i = 0;
		for (int offset = 0; offset < hash.length; offset++) {
			i = hash[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(i));
		}
		// ��byte����ת�����ַ�����Ȼ��Ϳ���ʹ�ü��ܺ���ַ�����
		return hexValue.toString();
	}

	

	// �����MD5����
	public static void main(String[] args) {
		String s = new String("654321");
		System.out.println("����ǰ��" + s);
		
		// ����MD5ֵ
		String encryptResult = encryptMD5(s);
		System.out.println("MD5��" + encryptResult);
		
	
	}

}
