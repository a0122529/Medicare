package com.neu.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

	public enum ALGO {
		MD5("MD5");

		public String algo;

		private ALGO(String algo) {
			this.algo = algo;
		}

		@Override
		public String toString() {
			return algo;
		}
	}

	private HashUtil() {

	}

	public static String generateHash(String msg, ALGO algo) {
		String hash = null;
		try {
			MessageDigest digest = MessageDigest.getInstance(algo.toString());
			byte[] hashedBytes = digest.digest(msg.getBytes());
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < hashedBytes.length; i++) {
				stringBuffer.append(Integer.toString((hashedBytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// byte[] encodedByte = Base64.encodeBase64(hashedBytes);

			// hash = new String(encodedByte);

			hash = stringBuffer.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hash;
	}
}
