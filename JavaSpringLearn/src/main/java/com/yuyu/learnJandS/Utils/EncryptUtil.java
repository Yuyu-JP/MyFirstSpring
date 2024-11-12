package com.yuyu.learnJandS.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptUtil {
	private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	// Method to hash a string
	public static String hash(String plainText) {
		return passwordEncoder.encode(plainText);
	}

	// Method to verify if a raw string matches the hashed string
	public static boolean matches(String plainText, String hashedText) {
		return passwordEncoder.matches(plainText, hashedText);
	}

}
