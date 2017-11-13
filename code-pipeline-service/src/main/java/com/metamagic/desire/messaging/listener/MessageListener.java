package com.metamagic.desire.messaging.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.metamagic.desire.messaging.channel.SinkChannel;
import com.metamagic.desire.messaging.event.DesignCompleted;

@Component
@EnableBinding(SinkChannel.class)
public class MessageListener {

	@StreamListener(SinkChannel.UI_CODE_FACTORY_INPUT)
	public void onReceive(Message<DesignCompleted> message){
		
		System.out.println(" MESSAGE HEADER " + message.getHeaders());
		
		
	}
	
}

