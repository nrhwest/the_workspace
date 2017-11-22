package com.webcrawler.bal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebPage {

	private Anchor anchor;
	private String webPageHash;
	private int anchorParseStatus, emailParseStatus;
	private Document document;
	
	// general constructor for crawling
	public WebPage(Anchor anchor) throws Exception {
		this.anchor = anchor;
		this.webPageHash = Hasher.toSha256(anchor.getAnchorHash() + Common.getTimestamp().toString());
		this.anchorParseStatus = 0;
		this.emailParseStatus = 0;
	}
	
	// Jsoup gets HTML
	public void loadDocFromWeb() {
		try {
			document = Jsoup.connect(anchor.getAnchorURL()).get();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(WebPage.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public String getWebPageHash() {
		return webPageHash;
	}

	public void setWebPageHash(String webPageHash) {
		// perform validation steps
		this.webPageHash = webPageHash;
	}

	public int getEmailParseStatus() {
		return emailParseStatus;
	}

	public void setEmailParseStatus(int emailParseStatus) {
		// perform validation steps
		this.emailParseStatus = emailParseStatus;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		// perform validation steps
		this.document = document;
	}

	public Anchor getAnchor() {
		return anchor;
	}

	public void setAnchor(Anchor anchor) {
		// perform validation steps
		this.anchor = anchor;
	}
	
	
}
