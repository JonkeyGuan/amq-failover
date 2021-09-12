package com.example.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

	final Logger log = LoggerFactory.getLogger(ProducerApplication.class);

	@Autowired
	JmsTemplate jmsTemplate;

	@Value("${destination.queue.name}")
	String queueName;

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int i = 0;
		while(true) {
			send(String.valueOf(++i));
		}
	}

	public void send(String msg) {

		log.info("sent：{}", msg);

		jmsTemplate.send(queueName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(msg);
				return textMessage;
			}
		});
	}

}
