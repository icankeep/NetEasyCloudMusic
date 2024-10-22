package com.passer.crawl.util;

import java.math.BigInteger;
/** 
 * @ClassName: EncryptTool<p>
 * @description: <p>
 * @author: passer<p>
 * @Date: 2019年3月25日 下午2:51:57<p>
 */
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class EncryptUtils {
	/**
	 * AES加密
	 * @param text	{\"username\": \"\", \"rememberLogin\": \"true\", \"password\": \"\"}<p>
	 * @param secKey	16位随机的十六进制数<p>
	 * @return	AES加密值<p>
	 */
	public static String encrypt(String text, String secKey) throws Exception {
		byte[] raw = secKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		// "算法/模式/补码方式"
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
		IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] encrypted = cipher.doFinal(text.getBytes());
		return Base64.getEncoder().encodeToString(encrypted);
	}

	/**
	 * 字符填充，如result长度大于等于n,则无需填充，取result后n个字符<p>
	 * 如result长度小于n，则将补充'0'到result末尾直到长度等于n
	 * @param result	需要填充的字符串
	 * @param n			需要填充完成之后字符串的位数
	 * @return			填充完成之后的字符串
	 */
	public static String zfill(String result, int n) {
		if (result.length() >= n) {
			result = result.substring(result.length() - n, result.length());
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = n; i > result.length(); i--) {
				stringBuilder.append("0");
			}
			stringBuilder.append(result);
			result = stringBuilder.toString();
		}
		return result;
	}

	/**
	 * 获取爬取过程中需要的加密参数，包含params、encSecKey<p>
	 * @return 返回形式为map，params=paramsValue,encSecKey=encSecKeyValue
	 */
	public static Map<String,String> encryptParams() throws Exception {
		//存储encSecKey和params
		Map<String,String> map = new HashMap<>();
		// 私钥，随机16位字符串（自己可改）
		String secKey = "cd859f54539b24b7";
		String text = "{\"username\": \"\", \"rememberLogin\": \"true\", \"password\": \"\"}";
		String modulus = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7";
		String nonce = "0CoJUm6Qyw8W8jud";
		String pubKey = "010001";
		System.out.println(modulus.length());
		// 2次AES加密，得到params
		String params = encrypt(encrypt(text, nonce), secKey);
		map.put("params", params);
		StringBuffer stringBuffer = new StringBuffer(secKey);
		// 逆置私钥
		secKey = stringBuffer.reverse().toString();
		String hex = Hex.encodeHexString(secKey.getBytes());
		BigInteger bigInteger1 = new BigInteger(hex, 16);
		BigInteger bigInteger2 = new BigInteger(pubKey, 16);
		BigInteger bigInteger3 = new BigInteger(modulus, 16);
		// RSA加密计算
		BigInteger bigInteger4 = bigInteger1.pow(bigInteger2.intValue()).remainder(bigInteger3);
		String encSecKey = Hex.encodeHexString(bigInteger4.toByteArray());
		// 字符填充
		encSecKey = zfill(encSecKey, 256);
		map.put("encSecKey", encSecKey);
		// 评论获取
		return map;
	}
}
