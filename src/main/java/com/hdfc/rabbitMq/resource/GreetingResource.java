package com.hdfc.rabbitMq.resource;

import com.hdfc.rabbitMq.producer.MessageProducer;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/send")
public class GreetingResource {
	
	@Inject
	MessageProducer messageProducer;
	
	
	  @GET
	  
	  @Path("/{name}")
	  public String hello(@PathParam("name") String name)
	  {
	  messageProducer.sendMessageRabbitMq("Hello, " + name + "!");
	  return "Hello, " + name + "!";
	  }
	 
	
		/*
		 * @POST public void sendMessage(@QueryParam("content") String content) {
		 * messageProducer.sendMessageRabbitMq(content); }
		 */
	

}
