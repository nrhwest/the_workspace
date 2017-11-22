package com.webcrawler.bal;

import java.sql.Timestamp;

public class Anchor {

	private Domain domain;
	private String anchorHash, anchorURL;
	private boolean	activated;
	private int scanStatus;
	private Timestamp modified, created;
	
	
	public Anchor(Domain domain, String anchorHash, String anchorURL, boolean activated, int scanStatus,
			Timestamp modified, Timestamp created) {
		this.domain = domain;
		this.anchorHash = anchorHash;
		this.anchorURL = anchorURL;
		this.activated = activated;
		this.scanStatus = scanStatus;
		this.modified = modified;
		this.created = created;
	}
	
	public Anchor(Domain domain, String anchorHash, String anchorURL) {
		this.domain = domain;
		this.anchorHash = anchorHash;
		this.anchorURL = anchorURL;
	}
	
	public Anchor(Domain domain, String anchorURL) throws Exception {
		this.domain = domain;
		this.anchorHash = Hasher.toSha256(anchorURL);
		this.anchorURL = anchorURL;
		this.activated = true;
		this.scanStatus = 0;
		this.modified = Common.getTimestamp();
		this.created = Common.getTimestamp();
	}
	
	public Domain getDomain() {
		return domain;
	}
	
	public void setDomain(Domain domain) {
		// perform validation steps
		this.domain = domain;
	}
	
	public String getAnchorHash() {
		return anchorHash;
	}
	
	public void setAnchorHash(String anchorHash) {
		// perform validation steps
		this.anchorHash = anchorHash;
	}
	
	public String getAnchorURL() {
		return anchorURL;
	}
	
	public void setAnchorURL(String anchorURL) {
		// perform validation steps
		this.anchorURL = anchorURL;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	public void setActivated(boolean activated) {
		// perform validation steps
		this.activated = activated;
	}
	
	public int getScanStatus() {
		return scanStatus;
	}
	
	public void setScanStatus(int scanStatus) {
		// perform validation steps
		this.scanStatus = scanStatus;
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
