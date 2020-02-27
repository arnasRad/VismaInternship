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

@Configuration
public class Config {

    @Value("${activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    Queue transactionQueue() {
        return new ActiveMQQueue("queues.payment");
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
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
