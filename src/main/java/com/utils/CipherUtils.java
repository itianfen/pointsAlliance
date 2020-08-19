package com.utils;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.*;

/**
 * @author zhaos
 */
public class CipherUtils {

    /**
     * 加盐
     */
    private static final String solt = "AfjeiowlfejwoAI434jergreg";

    public static byte[] aesEncryptToBytes(byte[] content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(encryptKey.getBytes()));
        Cipher cipher = Cipher.getInstance("AES");
        // cipher.init(Cipher.ENCRYPT_MODE, new
        // SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        cipher.init(Cipher.ENCRYPT_MODE, kgen.generateKey());
        return cipher.doFinal(content);
    }

    public static byte[] aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(decryptKey.getBytes()));
        Cipher cipher = Cipher.getInstance("AES");
        // cipher.init(Cipher.DECRYPT_MODE, new
        // SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        cipher.init(Cipher.DECRYPT_MODE, kgen.generateKey());
        return cipher.doFinal(encryptBytes);
    }

    public static KeyPair rsaGenerateKeyPair(String keyBase) throws Exception {
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024, new SecureRandom(keyBase.getBytes()));
        KeyPair kp = kpGen.generateKeyPair();
        return kp;
    }

    public static byte[] rsaEncrypt(PublicKey publicKey, byte[] content) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }

    public static byte[] rsaEncrypt(PrivateKey privateKey, byte[] content) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(content);
    }

    public static byte[] rsaDecrypt(PublicKey publicKey, byte[] content) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }

    public static byte[] rsaDecrypt(PrivateKey privateKey, byte[] content) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(content);
    }

    public static byte[] md5Digest(byte[] content) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(content);
        return md.digest();

    }

    public static String hexMd5Digest(String str) throws Exception {
        return Hex.encodeHexString(md5Digest(str.getBytes()));
    }

    public static String hexMd5Digest(String str, String charSet) throws Exception {
        return Hex.encodeHexString(md5Digest(str.getBytes(charSet)));
    }

    public static String sha1(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(data.getBytes());
        StringBuffer buf = new StringBuffer();
        byte[] bits = md.digest();
        for(int i=0;i<bits.length;i++){
            int a = bits[i];
            if(a<0) {
                a+=256;
            }
            if(a<16){
                buf.append("0");
            }
            buf.append(Integer.toHexString(a));
        }
        return buf.toString();
    }


    public static String passwordSalt(String password){
        try {
            password = hexMd5Digest(password);
            password = password + solt;
            return sha1(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws Exception {
        KeyPair pk = rsaGenerateKeyPair("hyxt");
        byte[] a = rsaEncrypt(pk.getPrivate(), "阿斯顿发".getBytes());
        System.out.println(Hex.encodeHexString(a));
        pk = rsaGenerateKeyPair("hyxt");
        a = rsaDecrypt(pk.getPublic(), a);
        System.out.println(new String(a));

        System.out.println(hexMd5Digest("123456"));
    }





}