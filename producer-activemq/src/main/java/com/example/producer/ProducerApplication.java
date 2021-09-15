package com.example.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@EnableJms
@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ProducerApplication.class);

	@Autowired
	public JmsTemplate jmsTemplate;

	@Value("${destination.queue.name}")
	String queueName;

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int i = 1;
		while (true) {
			send(String.valueOf(i++));
		}
	}

	public void send(String msg) {
		log.info("sent: {}", msg);
		jmsTemplate.convertAndSend(queueName, msg);
	}

}
