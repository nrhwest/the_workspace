package com.webcrawler.bal;

import java.security.MessageDigest;

public class Hasher {

	// returns SHA-256 hash of string in uppercase [SHA-256 is an algorithm]
	public static String toSha256(String input) throws Exception {
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		String text = input.toLowerCase();
		md.update(text.getBytes("ASCII"));
		byte[] hash = md.digest();

		StringBuilder sb = new StringBuilder();
		for (byte b : hash) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString().toUpperCase();
	}
}
