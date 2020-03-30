package com.mpec.encription;


import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;

import com.mpec.mongo.manager.GetTools;

public class AsymmetricTools {

	private static Cipher cipher;

	public static void initialize() {
		try {
			cipher = Cipher.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	public static PrivateKey getPrivate() throws Exception {
		byte[] keyBytes = GetTools.getAsymetricKey(GetTools.PRIVATE_KEY);
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}

	public static PublicKey getPublic() throws Exception {
		byte[] keyBytes = GetTools.getAsymetricKey(GetTools.PUBLIC_KEY);
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

	public static String encryptText(String text) throws Exception {
		cipher.init(Cipher.ENCRYPT_MODE, getPrivate());
		return Base64.encodeBase64String(cipher.doFinal(text.getBytes("UTF-8")));
	}

	public static String decryptText(String text) throws Exception {
		cipher.init(Cipher.DECRYPT_MODE, getPublic());
		return new String(cipher.doFinal(Base64.decodeBase64(text)), "UTF-8");
	}

}
