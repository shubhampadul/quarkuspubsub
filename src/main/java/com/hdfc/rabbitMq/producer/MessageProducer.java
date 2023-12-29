package com.hdfc.rabbitMq.producer;

import com.hdfc.rabbitMq.pojo.MessageEvent;

import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class MessageProducer {
	
	
	@Inject
	@Channel("messages")
	Emitter<MessageEvent> emitter;

	
	  @GET
	  @Produces(MediaType.TEXT_PLAIN) 
	  public void sendMessageRabbitMq(String content) 
	  { 
		  MessageEvent message = new MessageEvent();
	      message.setContent(content); emitter.send(message);
	    }
	 

	/*
	 * public void sendMessageRabbitMq(String content) { MessageEvent message = new
	 * MessageEvent(); message.setContent(content); emitter.send(message); }
	 */

}
