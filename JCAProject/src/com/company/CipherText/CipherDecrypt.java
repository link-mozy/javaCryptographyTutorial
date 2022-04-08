package com.company.CipherText;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Signature;

public class CipherDecrypt {

    static final int KEY_SIZE = 2048;

    public static void main(String[] args) throws Exception {

        // Creating a Signature object
        Signature signature = Signature.getInstance("SHA256withRSA");

        // Creating KeyPair generator object
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

        // Initializing the key pair generator
        keyPairGenerator.initialize(KEY_SIZE);

        // Generate the pair of keys
        KeyPair pair = keyPairGenerator.generateKeyPair();

        // Getting the public key from the key pair
        PublicKey publicKey = pair.getPublic();

        // Creating a Cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        // Initializing a Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        // Add data to the cipher
        byte[] input = "Welcome to Tutorialspoint".getBytes();
        cipher.update(input);

        // encrypting the data
        byte[] cipherText = cipher.doFinal();
        System.out.println("Encrypted Text:");
        System.out.println(new String(cipherText, "UTF8"));

        //Initializing the same cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

        //Decrypting the text
        byte[] decipheredText = cipher.doFinal(cipherText);
        System.out.println("Decrypted Text:");
        System.out.println(new String(decipheredText));
    }
}
