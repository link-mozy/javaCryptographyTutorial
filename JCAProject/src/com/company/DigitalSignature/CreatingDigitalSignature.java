package com.company.DigitalSignature;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;

public class CreatingDigitalSignature {

    static final int KEY_SIZE = 2048;

    public static void main(String[] args) throws Exception {

        // Accepting text from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some text");
        String msg = sc.nextLine();

        // Creating KeyPair generator object
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");

        // Initializing the key pair generator
        keyPairGenerator.initialize(KEY_SIZE);

        // Generator the pair of keys
        KeyPair pair = keyPairGenerator.generateKeyPair();

        // Getting the private key from the key pair
        PrivateKey privateKey = pair.getPrivate();

        // Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withDSA");

        // Initialize the signature
        sign.initSign(privateKey);
        byte[] bytes = msg.getBytes();

        // Adding data to the signature
        sign.update(bytes);

        // Calculating the signature
        byte[] signature = sign.sign();

        // Printing the signature
        System.out.println("Digital signature for given text : " + new String(signature, "UTF8"));
        System.out.println("Plain text : " + new String(bytes, "UTF8"));
    }
}
