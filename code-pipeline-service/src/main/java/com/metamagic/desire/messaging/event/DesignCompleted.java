package com.metamagic.desire.messaging.event;

import java.io.Serializable;

public class DesignCompleted implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1902103196115766525L;

	private String designId;
	
	private String designMetadata;

	public DesignCompleted(String designId, String designMetadata){
		this.designId = designId;
		this.designMetadata = designMetadata;
	}

	public String getDesignId() {
		return designId;
	}

	public String getDesignMetadata() {
		return designMetadata;
	}

}
