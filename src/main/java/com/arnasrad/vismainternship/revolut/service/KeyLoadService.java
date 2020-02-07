package com.arnasrad.vismainternship.revolut.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Service
public class KeyLoadService {
    @Value("${resources.privatekey.path}")
    private String privateKeyPath;

    /**
     * Gets the private key from resources/static/certificates folder
     * @return PrivateKey object
     */
    public PrivateKey getPrivateKey(){

        return generatePrivateKey(privateKeyPath);
    }

    private PrivateKey generatePrivateKey(String fileName) {
        try {

            PKCS8EncodedKeySpec keySpec
                    = new PKCS8EncodedKeySpec(
                            Base64.getDecoder().decode(loadPrivateKey(fileName))
            );

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            return keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | IOException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String loadPrivateKey(String fileName) throws IOException, URISyntaxException {

        URL keyUrl = getClass().getClassLoader().getResource(fileName);
        return formatPrivateKey(keyUrl);
    }

    private String formatPrivateKey(URL keyUrl) throws URISyntaxException, IOException {

        byte[] keyBytes = Files.readAllBytes(Paths.get(keyUrl.toURI()));
        String privateKeyContent = new String(keyBytes);

        return privateKeyContent
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "");
    }
}
