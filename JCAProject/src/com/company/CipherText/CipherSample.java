package com.company.CipherText;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

public class CipherSample {

    static final int KEY_SIZE = 2048;

    public static void main(String[] args) throws Exception {

        // Creating a signature object
        Signature signature = Signature.getInstance("SHA256withRSA");

        // Creating KeyPair generator object
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

        // Initializing the key pair generator
        keyPairGenerator.initialize(KEY_SIZE);

        // Generating the pair of keys
        KeyPair pair = keyPairGenerator.generateKeyPair();

        // Creating a Cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        // Initializing a Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        // Adding data to the cipher
        byte[] input = "Welcome to Tutorialspoint".getBytes();
        cipher.update(input);

        // encrypting the data
        byte[] cipherText = cipher.doFinal();
        System.out.println(new String(cipherText, "UTF8"));
    }
}
