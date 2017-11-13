package com.metamagic.desire.messaging.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SinkChannel {
	
	String UI_CODE_FACTORY_INPUT = "ui_code_factory_channel";
	
	String JAVA_CODE_FACTORY_INPUT = "java_code_factory_channel";

	@Input(SinkChannel.UI_CODE_FACTORY_INPUT)
	SubscribableChannel uiCodeFactoryChannel();
	
	@Input(SinkChannel.JAVA_CODE_FACTORY_INPUT)
	SubscribableChannel javaCodeFactoryChannel();
}
