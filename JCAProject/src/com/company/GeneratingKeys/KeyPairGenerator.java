package com.company.GeneratingKeys;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyPairGenerator {

    static final int KEY_SIZE = 2048;

    public static void main(String[] args) throws Exception {

        // Creating KeyPair generator object
        java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance("DSA");

        // Initializing the KeyPairGenerator
        keyPairGenerator.initialize(KEY_SIZE);

        // Generating the pair of keys
        KeyPair pair = keyPairGenerator.generateKeyPair();

        // Getting the private key from the key pair
        PrivateKey privateKey = pair.getPrivate();

        // Getting the public key from the key pair
        PublicKey publicKey = pair.getPublic();

        System.out.println("keys generated");
        System.out.println("private key : " + privateKey.toString());
        System.out.println("public key : " + publicKey.toString());
    }
}
