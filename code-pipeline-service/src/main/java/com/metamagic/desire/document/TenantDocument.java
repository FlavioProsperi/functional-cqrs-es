package com.metamagic.desire.document;

public class TenantDocument extends AuditDocument {

	private String mteid;

	public TenantDocument(){
	}
	
	public String getMteid() {
		return mteid;
	}

	public void setMteid(String mteid) {
		this.mteid = mteid;
	}
	
}
