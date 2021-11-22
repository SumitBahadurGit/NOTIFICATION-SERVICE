package com.nepCafe.notification.deserializer;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.nepCafe.kafka.client.models.Notification;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CusomtDeserializer implements Deserializer<Notification> {

    private ObjectMapper objectMapper = new ObjectMapper();

    
	@Override
	public Notification deserialize(String topic, byte[] data) {
		 try {
	            if (data == null){
	                System.out.println("Null received at deserializing");
	                return null;
	            }
	            System.out.println("Deserializing...");
	            return objectMapper.readValue(new String(data, "UTF-8"), Notification.class);
	        } catch (Exception e) {
	            throw new SerializationException("Error when deserializing byte[] to MessageDto");
	        }
	}
	

}
