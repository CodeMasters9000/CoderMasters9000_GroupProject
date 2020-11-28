package com.CodeMasters_9000.controller_CodeMasters_9000;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login_Feature_ControllerClass {

	private static char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String generateHash(String data, String algorithm) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance(algorithm);
		md.reset();
		byte[] hash = md.digest(data.getBytes());
		return bytesToStringHex(hash);

	}

	private static String bytesToStringHex(byte[] hash) {
		char[] hexChars = new char[hash.length * 2];
		for (int i = 0; i < hash.length; i++) {
			int v = hash[i] & 0xFF;
			hexChars[i * 2] = hexArray[v >>> 4];
			hexChars[i * 2 + 1] = hexArray[v & 0x0F];

		}
		return new String(hexChars);
	}
}
