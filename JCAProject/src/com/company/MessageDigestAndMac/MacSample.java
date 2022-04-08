package com.company.MessageDigestAndMac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import java.security.Key;
import java.security.SecureRandom;

public class MacSample {

    public static void main(String[] args) throws Exception {

        // Creating a KeyGenerator object
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");

        // Creating a SucreRandom object
        SecureRandom secureRandom = new SecureRandom();

        // Initializing the KeyGenerator
        keyGen.init(secureRandom);

        // Creating / Generating a key
        Key key = keyGen.generateKey();

        // Creating a Mac object
        Mac mac = Mac.getInstance("HmacSHA256");

        // Initializing  the Mac object
        mac.init(key);

        // Computing the Mac
        String msg = new String("Hi how are you");
        byte[] bytes = msg.getBytes();
        byte[] macResult = mac.doFinal(bytes);

        System.out.println("Plain text: ");
        System.out.println(msg);

        System.out.println("Mac result: ");
        System.out.println(new String(macResult));
    }
}
