package com.webcrawler.bal;

import java.sql.Timestamp;

public class Domain {
	
	private boolean activated;
	private String domainHash, domainURL;
	private Timestamp modified, created;
	
	
	
	public Domain(String domainHash, String domainURL) {
		this.domainHash = domainHash;
		this.domainURL = domainURL;
	}
	
	public Domain(String domainURL) throws Exception {
		this.domainHash = Hasher.toSha256(domainURL);
		this.domainURL = domainURL;
		this.modified = Common.getTimestamp();
		this.created = Common.getTimestamp();
		this.activated = true;
	}
	
	
	// used when populating from database
	public Domain(boolean activated, String domainHash, String domainURL, 
			Timestamp modified, Timestamp created) {
		this.activated = activated;
		this.domainHash = domainHash;
		this.domainURL = domainURL;
		this.modified = modified;
		this.created = created;
	}

	public boolean isActivated() {
		return activated;
	}
	
	public void setActivated(boolean activated) {
		// perform validation steps
		this.activated = activated;
	}
	
	public String getDomainHash() {
		return domainHash;
	}
	
	public void setDomainHash(String domainHash) {
		// perform validation steps
		this.domainHash = domainHash;
	}
	
	public String getDomainURL() {
		return domainURL;
	}
	
	public void setDomainURL(String domainURL) {
		// perform validation steps
		this.domainURL = domainURL;
	}
	public Timestamp getModified() {
		return modified;
	}
	
	public void setModified(Timestamp modified) {
		// perform validation steps
		this.modified = modified;
	}
	
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		// perform validation steps
		this.created = created;
	}
	
	
}
