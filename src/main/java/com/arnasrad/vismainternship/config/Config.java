package com.arnasrad.vismainternship.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.client.RestTemplate;

import javax.jms.Queue;
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
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Queue paymentQueue() {
        return new ActiveMQQueue(paymentQueueString);
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        factory.setTrustedPackages(new ArrayList<>(Arrays.asList("com.arnasrad.vismainternship.model.dto.payment")));
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
