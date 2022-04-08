package com.company.GeneratingKeys;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

public class KeyGeneratorExample {

    public static void main(String[] args) throws Exception {
        // Creating a KeyGenerator object
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");

        // Creating a SecureRandom object
        SecureRandom secureRandom = new SecureRandom();

        // Initializing the KeyGenerator
        keyGenerator.init(secureRandom);

        // Creating / Generating a key
        Key key = keyGenerator.generateKey();

        System.out.println(key);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(cipher.ENCRYPT_MODE, key);

        String msg = new String("Hi how are you");
        byte[] bytes = cipher.doFinal(msg.getBytes());
        System.out.println(bytes);
    }
}
