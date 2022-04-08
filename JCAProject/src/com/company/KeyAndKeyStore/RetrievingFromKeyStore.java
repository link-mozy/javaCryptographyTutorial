package com.company.KeyAndKeyStore;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.security.KeyStore;

public class RetrievingFromKeyStore {

    public static void main(String[] args) throws Exception {

        // Creating the KeyStore object
        KeyStore keyStore = KeyStore.getInstance("JCEKS");

        // Loading the KeyStore object
        char[] password = "changeit".toCharArray();
        // 사용하고 있는 자바 경로에서 jre/lib/security/cacerts 파일 위치 입력
        String path = "C:/utils/java/zulu8.60.0.21-ca-jdk8.0.322-win_x64/jre/lib/security/cacerts";
        java.io.FileInputStream fls = new FileInputStream(path);

        keyStore.load(fls, password);

        // Creating the KeyStore.ProtectionParameter object
        KeyStore.ProtectionParameter protectionParameter = new KeyStore.PasswordProtection(password);

        // Creating SecretKey object
        SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");

        // Creating SecretKeyEntry object
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(mySecretKey);
        keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParameter);

        // Storing the KeyStore object
        java.io.FileOutputStream fos = null;
        fos = new java.io.FileOutputStream("./temp/newKeyStoreName");
        keyStore.store(fos, password);

        // Creating the KeyStore.SecretKeyEntry object
        KeyStore.SecretKeyEntry secretKeyEnt = (KeyStore.SecretKeyEntry) keyStore.getEntry("secretKeyAlias", protectionParameter);

        // Creating SecretKey object
        SecretKey mysecretKey = secretKeyEnt.getSecretKey();
        System.out.println("Algorithm used to generate key : " + mysecretKey.getAlgorithm());
        System.out.println("Format used for the key : " + mysecretKey.getFormat());
    }
}
