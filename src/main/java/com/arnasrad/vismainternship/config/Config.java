package com.arnasrad.vismainternship.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.client.RestTemplate;

import javax.jms.Queue;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class Config {

    @Value("${activemq.broker-url}")
    private String brokerUrl;

    @Value("${jms.queues.payment}")
    private String paymentQueueString;

    @Bean
    public String paymentQueueName() {
        return paymentQueueString;
    }

    @Bean
    public RestTemplate restTemplate() throws KeyStoreException, IOException, UnrecoverableKeyException,
            NoSuchAlgorithmException, CertificateException, KeyManagementException {
        char[] password = "admin".toCharArray();
        KeyStore clientStore = getPKCS12KeyStore(password);

        SSLContext sslContext = SSLContextBuilder.create()
                .setProtocol("TLS")
                .loadKeyMaterial(clientStore, password)
                .build();

        HttpClient client = HttpClients.custom().setSSLContext(sslContext).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(client);
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);

        return new RestTemplate(requestFactory);
    }

    private KeyStore getPKCS12KeyStore(char[] password) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/static/certificates/dnb" +
                "/pkprivatecertificate.p12");
        keyStore.load(fileInputStream, password);

        return keyStore;
    }

    @Bean
    public Queue paymentQueue() {
        return new ActiveMQQueue(paymentQueueString);
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        factory.setTrustedPackages(new ArrayList<>(Arrays.asList("com.arnasrad.vismainternship.model.dto")));
        return factory;
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate() {
        return new JmsMessagingTemplate(activeMQConnectionFactory());
    }

    @Bean
    public SimpleDateFormat simpleDateFormat(@Value("${dates.defaultFormat}") String defaultDateFormat) {
        return new SimpleDateFormat(defaultDateFormat);
    }
}
