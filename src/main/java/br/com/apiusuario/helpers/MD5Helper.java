package br.com.apiusuario.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class MD5Helper {
	
public static String encryptMD5(String input) {
	
	try {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest(input.getBytes());
		
		BigInteger no = new BigInteger(1, messageDigest);
		
		StringBuilder hashText = new StringBuilder(no.toString(16));
		while (hashText.length() < 32) {
			hashText.insert(0, "0");
		}
		return hashText.toString();
	}
	
	catch(NoSuchAlgorithmException e) {
		throw new RuntimeException("Erro ao criptografar usando o algoritmoMD5", e);
		
	}
	
}
	
	
}
