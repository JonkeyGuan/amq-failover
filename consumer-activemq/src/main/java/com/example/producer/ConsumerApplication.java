package com.example.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class ConsumerApplication {

	final Logger log = LoggerFactory.getLogger(ConsumerApplication.class);

	@Autowired
	JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@JmsListener(destination = "${destination.queue.name}")
	public void recive(String content) {
		log.info("recieved: {}", content);
	}

}
