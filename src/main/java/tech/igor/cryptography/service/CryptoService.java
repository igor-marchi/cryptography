package tech.igor.cryptography.service;

import org.jasypt.util.text.StrongTextEncryptor;

public class CryptoService {
    private static final String CRYPTO_PASSWORD = System.getenv("CRYPTO_PASSWORD");
    private static final StrongTextEncryptor encryptor = new StrongTextEncryptor();

    static {
        if (CRYPTO_PASSWORD == null || CRYPTO_PASSWORD.isEmpty()) {
            throw new IllegalStateException("CRYPTO_PASSWORD environment variable is not set or is empty");
        }
        encryptor.setPassword(CRYPTO_PASSWORD);
    }

    public static String encrypt(String rawText) {
        return encryptor.encrypt(rawText);
    }

    public static String decrypt(String encryptedText) {
        return encryptor.decrypt(encryptedText);
    }
}
