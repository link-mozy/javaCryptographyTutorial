package com.company.DigitalSignature;

import javax.crypto.KeyGenerator;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;

public class SignatureVerification {

    static final int KEY_SIZE = 2048;

    public static void main(String[] args) throws Exception {

        // Creating KeyPair generator object
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");

        // Initializing the key pair generator
        keyPairGenerator.initialize(KEY_SIZE);

        // Generate the pair of keys
        KeyPair pair = keyPairGenerator.generateKeyPair();

        // Getting the private from the key pair
        PrivateKey privateKey = pair.getPrivate();

        // Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withDSA");

        // Initializing the signature
        sign.initSign(privateKey);
        byte[] bytes = "Hello how are you".getBytes();

        // Adding data to the signature
        sign.update(bytes);

        // Calculating the signature
        byte[] signature = sign.sign();

        // Initializing the signature
        sign.initVerify(pair.getPublic());
        sign.update(bytes);

        // Verifying the signature
        boolean bool = sign.verify(signature);

        System.out.println("public key : " + pair.getPublic().toString());
        System.out.println("signature : " + new String(signature, "UTF8"));
        System.out.println("bytes : " + new String(bytes, "UTF8"));

        if (bool) {
            System.out.println("Signature verified");
        } else {
            System.out.println("Signature failed");
        }
    }
}
