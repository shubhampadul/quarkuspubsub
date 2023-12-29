package com.hdfc.rabbitMq.consumer;



import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.hdfc.rabbitMq.pojo.MessageEvent;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageConsumer {
	
	@Incoming("messages")
    public void handleMessage(MessageEvent message) {
        System.out.println("Received message: " + message.getContent());
    }

}
