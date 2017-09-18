package com.example.demo;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
	public static String encrypt(String unencryptedString) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		MessageDigest md = MessageDigest.getInstance("md5");
		String key = "lk_za0mdATbt78D6xoyW2ni";
		byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

		for (int j = 0, k = 16; j < 8;) {
			keyBytes[k++] = keyBytes[j++];
		}

		SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");
		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);

		byte[] plainTextBytes = unencryptedString.getBytes("utf-8");
		byte[] buf = cipher.doFinal(plainTextBytes);
		String encoded = Base64.getEncoder().encodeToString(buf);

		return encoded;
	}
	    
	
}
